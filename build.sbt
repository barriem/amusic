import Dependencies.*

val scala3Version = "3.1.3"

lazy val root = project
  .in(file("."))
  .settings(
    organization := "com.bcm",
    name         := "amusic",
    version      := "0.1.0-SNAPSHOT",
    scalaVersion := scala3Version,
    libraryDependencies ++= Seq(
      catsEffect,
      mUnit
    )
  )
