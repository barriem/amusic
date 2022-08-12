package com.bcm.amusic.service

import cats.Applicative
import cats.syntax.applicative._
import com.bcm.amusic.domain.Scale

class RenderService[F[_]: Applicative] {
  def renderScale(scale: Scale): F[String] = {
    val header = s"[${scale.rootNote.render} ${scale.scaleType} scale degrees]"

    val degreeString = scale.degrees
      .map { degree =>
        s"  ${degree.degree}\t: ${degree.note.render}"
      }
      .mkString("\n")

    s"$header \n$degreeString".pure[F]
  }
}
