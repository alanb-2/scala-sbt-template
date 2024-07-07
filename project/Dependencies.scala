import sbt.*

object Dependencies {

  val scalaTestVersion = "3.2.19"

  val scalacticDependency = "org.scalactic" %% "scalactic" % scalaTestVersion
  val scalaTestDependency = "org.scalatest" %% "scalatest" % scalaTestVersion

  val rootDependencies = Seq(
      scalacticDependency % Test,
      scalaTestDependency % Test
  )

}
