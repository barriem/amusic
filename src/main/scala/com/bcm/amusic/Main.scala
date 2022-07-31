package com.bcm.amusic

import cats.effect.IOApp
import cats.effect.ExitCode
import cats.effect.IO
import com.bcm.amusic.service.ScaleService
import com.bcm.amusic.domain.Note

object Main extends IOApp {

  override def run(args: List[String]): IO[ExitCode] = {
    val scaleService = new ScaleService[IO]

    for {
      scale <- scaleService.buildMinorScale(Note.C)
      _ = println(scale.renderDegrees)
    } yield ExitCode.Success
  }
}
