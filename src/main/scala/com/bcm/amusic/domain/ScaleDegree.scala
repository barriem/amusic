package com.bcm.amusic.domain

import enumeratum._

sealed trait ScaleDegree extends EnumEntry

object ScaleDegree extends Enum[ScaleDegree] {
  val values = findValues

  case object One   extends ScaleDegree
  case object Two   extends ScaleDegree
  case object Three extends ScaleDegree
  case object Four  extends ScaleDegree
  case object Five  extends ScaleDegree
  case object Six   extends ScaleDegree
  case object Seven extends ScaleDegree
}
