package com.bcm.amusic.domain

enum Note(val short: String):
  case A      extends Note("A")
  case ASharp extends Note("A#")
  case B      extends Note("B")
  case C      extends Note("C")
  case CSharp extends Note("C#")
  case D      extends Note("D")
  case DSharp extends Note("D#")
  case E      extends Note("E")
  case F      extends Note("F")
  case FSharp extends Note("F#")
  case G      extends Note("G")
  case GSharp extends Note("G#")

object Note {
  def fromRoot(note: Note): List[Note] = {
    val allNotes                 = Note.values
    val (rootOnwards, remaining) = allNotes.toList.splitAt(note.ordinal).swap
    rootOnwards ++ remaining
  }
}
