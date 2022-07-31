package com.bcm.amusic.domain

enum Interval:
  case Unison        extends Interval
  case MinorSecond   extends Interval
  case MajorSecond   extends Interval
  case MinorThird    extends Interval
  case MajorThird    extends Interval
  case PerfectFourth extends Interval
  case TriTone       extends Interval
  case PerfectFifth  extends Interval
  case MinorSixth    extends Interval
  case MajorSixth    extends Interval
  case MinorSeventh  extends Interval
  case MajorSeventh  extends Interval

object Interval {
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
