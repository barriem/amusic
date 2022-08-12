package com.bcm.amusic.domain

import enumeratum._

sealed trait Note extends EnumEntry

object Note extends Enum[Note] {
  val values = findValues

  case object A      extends Note
  case object ASharp extends Note
  case object B      extends Note
  case object C      extends Note
  case object CSharp extends Note
  case object D      extends Note
  case object DSharp extends Note
  case object E      extends Note
  case object F      extends Note
  case object FSharp extends Note
  case object G      extends Note
  case object GSharp extends Note

  def fromRoot(note: Note): List[Note] = {
    val allNotes                 = Note.values
    val (rootOnwards, remaining) = allNotes.toList.splitAt(allNotes.indexOf(note)).swap
    rootOnwards ++ remaining
  }

  def fromNameWithOverload(note: String): Note =
    Note.withNameInsensitiveOption(note) match {
      case Some(n) => n
      case None    => overloads.getOrElse(note, throw new NoSuchElementException)
    }

  val overloads: Map[String, Note] = Map(
    "A#" -> ASharp,
    "Ab" -> GSharp,
    "B#" -> C,
    "Bb" -> ASharp,
    "C#" -> CSharp,
    "Cb" -> B,
    "D#" -> DSharp,
    "Db" -> CSharp,
    "E#" -> F,
    "Eb" -> DSharp,
    "F#" -> FSharp,
    "Fb" -> E,
    "G#" -> GSharp,
    "Gb" -> FSharp
  )
}
