package com.bcm.amusic.domain

import enumeratum._

sealed trait Interval extends EnumEntry

object Interval extends Enum[Interval] {
  val values = findValues

  case object Unison        extends Interval
  case object MinorSecond   extends Interval
  case object MajorSecond   extends Interval
  case object MinorThird    extends Interval
  case object MajorThird    extends Interval
  case object PerfectFourth extends Interval
  case object TriTone       extends Interval
  case object PerfectFifth  extends Interval
  case object MinorSixth    extends Interval
  case object MajorSixth    extends Interval
  case object MinorSeventh  extends Interval
  case object MajorSeventh  extends Interval

  val majorScale: List[Interval] =
    List(
      Unison,
      MajorSecond,
      MajorThird,
      PerfectFourth,
      PerfectFifth,
      MajorSixth,
      MajorSeventh
    )

  val minorScale: List[Interval] =
    List(
      Unison,
      MajorSecond,
      MinorThird,
      PerfectFourth,
      PerfectFifth,
      MinorSixth,
      MinorSeventh
    )
}
