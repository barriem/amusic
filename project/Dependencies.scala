import sbt.*
import Versions.*

object Dependencies {
  lazy val catsEffect = "org.typelevel" %% "cats-effect" % catsEffectVersion
  lazy val mUnit      = "org.scalameta" %% "munit"       % mUnitVersion % Test
}
