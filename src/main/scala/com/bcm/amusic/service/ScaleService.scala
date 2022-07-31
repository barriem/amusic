package com.bcm.amusic.service

import com.bcm.amusic.domain.Interval
import com.bcm.amusic.domain.Note
import com.bcm.amusic.domain.Scale
import cats.syntax.applicative._
import cats.syntax.functor._
import cats.syntax.flatMap._
import cats.Monad
import cats.Applicative

class ScaleService[F[_]: Monad] {
  def buildScaleFromIntervals(
      rootNote: Note,
      intervals: List[Interval]
  ): F[Scale] = for {
    notes              <- Note.fromRoot(rootNote).pure[F]
    allIntervals       <- Interval.values.toList.pure[F]
    notesWithIntervals <- notes.zip(allIntervals).pure[F]
    scaleNotes <- notesWithIntervals
      .collect {
        case (note, interval) if intervals.contains(interval) => note
      }
      .pure[F]
  } yield Scale(scaleNotes, intervals)

  def buildMajorScale(rootNote: Note): F[Scale] =
    buildScaleFromIntervals(rootNote, Interval.majorScale)

  def buildMinorScale(rootNote: Note): F[Scale] =
    buildScaleFromIntervals(rootNote, Interval.minorScale)
}
