package com.bcm.amusic.domain

import enumeratum._

sealed trait ScaleType extends EnumEntry

object ScaleType extends Enum[ScaleType] {
  val values = findValues

  case object Minor extends ScaleType
  case object Major extends ScaleType
}
