package com.bcm.amusic.service

import cats.Applicative
import cats.syntax.applicative._
import com.bcm.amusic.domain.Scale

class RenderService[F[_]: Applicative] {

  def renderScale(scale: Scale): F[String] =
    scale.degrees
      .map { degree =>
        s"${degree.degree.toString}\t : ${degree.note.toString.replace("Sharp", "#")}"
      }
      .mkString("\n")
      .pure[F]
}
