import Dependencies._
import sbtassembly.AssemblyPlugin.autoImport.assembly

name := "scala-sbt-template"
ThisBuild / crossPaths := false
ThisBuild / organization := "my.org"
ThisBuild / scalacOptions += ""
ThisBuild / scalaVersion := "2.13.5"
ThisBuild / version := "0.1"

ThisBuild / resolvers ++= Seq(
  Resolver.mavenLocal
)

lazy val commonSettings = Seq(
  libraryDependencies ++= rootDependencies,
  Test / unmanagedSourceDirectories += baseDirectory.value / "src/it/scala"
)

lazy val root = (project in file("."))
  .aggregate(
    common,
    core
  )
  .enablePlugins(JavaAppPackaging)
  .settings(commonSettings)

lazy val common = (project in file("common"))
  .settings(
    commonSettings,
    name := "common",
    assembly / test := {}
  )

lazy val core = (project in file("core"))
  .dependsOn(common)
  .enablePlugins(JavaAppPackaging)
  .settings(
    commonSettings,
    name := "core",
    assembly / mainClass := Some(s"${organization.value}.Main"),
    assembly / assemblyJarName := "scala-sbt-template-core.jar",
    assembly / test := {}
  )

assembly / assemblyMergeStrategy := {
  case x =>
    val oldStrategy = (assembly / assemblyMergeStrategy).value
    oldStrategy(x)
}

publishMavenStyle := true
