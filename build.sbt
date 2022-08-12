import Dependencies._

val scala2Version = "2.13.8"

lazy val root = project
  .in(file("."))
  .settings(
    organization := "com.bcm",
    name         := "amusic",
    version      := "0.1.0-SNAPSHOT",
    scalaVersion := scala2Version,
    libraryDependencies ++= Seq(
      catsEffect,
      declineEffect,
      enumeratum,
      mUnit
    )
  )
