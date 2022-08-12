package com.bcm.amusic.service

import com.bcm.amusic.domain.{Degree, Interval, Note, Scale, ScaleDegree}
import cats.syntax.applicative._
import cats.syntax.functor._
import cats.syntax.flatMap._
import cats.Monad

class ScaleService[F[_]: Monad] {
  def buildScaleFromIntervals(
      rootNote: Note,
      intervals: List[Interval]
  ): F[Scale] = for {
    notes              <- Note.fromRoot(rootNote).pure[F]
    allIntervals       <- Interval.values.toList.pure[F]
    notesWithIntervals <- notes.zip(allIntervals).pure[F]
    degrees <- notesWithIntervals
      .collect {
        case (note, interval) if intervals.contains(interval) => (note, interval)
      }
      .zip(ScaleDegree.values)
      .map { case ((note, interval), degree) => Degree(degree, note, interval) }
      .pure[F]
  } yield Scale(degrees)

  def buildMajorScale(rootNote: Note): F[Scale] =
    buildScaleFromIntervals(rootNote, Interval.majorScale)

  def buildMinorScale(rootNote: Note): F[Scale] =
    buildScaleFromIntervals(rootNote, Interval.minorScale)
}
