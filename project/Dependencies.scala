import sbt._
import Versions._

object Dependencies {
  lazy val catsEffect    = "org.typelevel" %% "cats-effect"    % catsEffectVersion
  lazy val declineEffect = "com.monovore"  %% "decline-effect" % declineEffectVersion
  lazy val enumeratum    = "com.beachape"  %% "enumeratum"     % enumeratumVersion
  lazy val mUnit         = "org.scalameta" %% "munit"          % mUnitVersion % Test
}
