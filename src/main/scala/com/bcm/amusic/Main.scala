package com.bcm.amusic

import cats.effect.{ExitCode, IO}
import cats.syntax.apply._
import com.bcm.amusic.domain.{Note, Scale, ScaleType}
import com.bcm.amusic.service.{RenderService, ScaleService}
import com.monovore.decline._
import com.monovore.decline.effect._

object Main extends CommandIOApp(name = "Amusic", header = "musical related fun!") {
  case class ShowScale(rootNote: Note, scaleType: ScaleType)

  val noteArg: Opts[Note] = Opts
    .option[String]("root", "The root note of the scale", short = "r")
    .map(Note.fromNameWithOverload)

  val scaleTypeArg: Opts[ScaleType] = Opts
    .option[String]("type", "The type of the scale", short = "t")
    .map(ScaleType.withNameInsensitive)

  val showScaleCommand: Opts[ShowScale] =
    Opts.subcommand("scale", "Shows the notes in a scale") {
      (noteArg, scaleTypeArg).mapN { (note, scaleType) =>
        ShowScale(note, scaleType)
      }
    }

  val scaleService  = new ScaleService[IO]
  val renderService = new RenderService[IO]

  private def runApp(root: Note, scaleF: Note => IO[Scale]): IO[ExitCode] =
    for {
      scale    <- scaleF(root)
      rendered <- renderService.renderScale(scale)
      _ = println(rendered)
    } yield ExitCode.Success

  override def main: Opts[IO[ExitCode]] =
    showScaleCommand.map {
      case ShowScale(root, ScaleType.Minor) => runApp(root, scaleService.buildMinorScale)
      case ShowScale(root, ScaleType.Major) => runApp(root, scaleService.buildMajorScale)
    }
}
