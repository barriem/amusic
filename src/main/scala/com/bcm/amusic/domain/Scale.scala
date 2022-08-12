package com.bcm.amusic.domain

final case class Degree(degree: ScaleDegree, note: Note, interval: Interval)
final case class Scale(degrees: List[Degree])
