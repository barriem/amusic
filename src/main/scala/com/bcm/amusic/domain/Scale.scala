package com.bcm.amusic.domain

final case class Scale(notes: List[Note], intervals: List[Interval]) {
  def renderIntervals: String = {
    notes
      .zip(intervals)
      .map { case (note, interval) =>
        s"${interval.toString()}: ${note.short}"
      }
      .mkString("\n")
  }

  def renderDegrees: String = {
    notes.zipWithIndex
      .map { case (note, index) =>
        s"${index + 1}: ${note.short}"
      }
      .mkString("\n")
  }
}
