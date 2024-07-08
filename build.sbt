import Dependencies.*

name := "scala-sbt-template"
ThisBuild / organization := "my.org"
ThisBuild / coverageEnabled := true
ThisBuild / crossPaths := false
ThisBuild / javacOptions ++= Seq(
  "-source",
  "21",
  "-target",
  "21"
)
ThisBuild / resolvers ++= Seq(
  Resolver.mavenLocal
)
ThisBuild / scalacOptions ++= Seq(
  "-deprecation",
  "-feature",
  "-unchecked",
  "-Wunused:all",
  "-Xfatal-warnings"
)
ThisBuild / scalaVersion := "3.3.3"
ThisBuild / version := git.gitHeadCommit.value.get.take(7)

lazy val commonSettings = Seq(
  libraryDependencies ++= rootDependencies,
  Test / unmanagedSourceDirectories += baseDirectory.value / "src/it/scala"
)

lazy val root = (project in file("."))
  .aggregate(
    common,
    core
  )
  .enablePlugins(JavaServerAppPackaging)
  .settings(commonSettings)

lazy val common = (project in file("common"))
  .settings(
    commonSettings,
    name := "common",
    assembly / test := {}
  )

lazy val core = (project in file("core"))
  .dependsOn(common)
  .enablePlugins(JavaServerAppPackaging)
  .settings(
    commonSettings,
    name := "core",
    assembly / mainClass := Some(s"${organization.value}.Main"),
    assembly / assemblyJarName := s"${name.value}-${version.value}.jar",
    assembly / test := {}
  )

assembly / assemblyMergeStrategy := {
  case x =>
    val oldStrategy = (assembly / assemblyMergeStrategy).value
    oldStrategy(x)
}

publishMavenStyle := true
