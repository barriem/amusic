package com.bcm.amusic.domain

import com.bcm.amusic.domain.Interval.*

class IntervalSpec extends munit.FunSuite {
  test("Major scale contains the expected intervals") {
    val expected = List(
      Unison,
      MajorSecond,
      MajorThird,
      PerfectFourth,
      PerfectFifth,
      MajorSixth,
      MajorSeventh
    )
    assertEquals(Interval.majorScale, expected)
  }
}
