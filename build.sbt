ThisBuild / version := "0.1"
ThisBuild / scalaVersion := "2.13.6"
ThisBuild / organizationName := "org.tohasan"

lazy val scalaPlayground = project.in(file("."))
  .settings(
    name := "scala-playground",
    libraryDependencies += "org.typelevel" %% "cats-effect" % "3.2.9",
    addCompilerPlugin("com.olegpy" %% "better-monadic-for" % "0.3.1")
  )
