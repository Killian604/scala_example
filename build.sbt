ThisBuild / scalaVersion:= "2.12.7"
ThisBuild / organization:= "com.example"
ThisBuild / version     := "0.1.0-SNANPSHOT"
ThisBuild / trackInternalDependencies := TrackLevel.TrackIfMissing


val scalaTest = "org.scalatest" %% "scalatest" % "3.0.5"
val playJson =  "com.typesafe.play" %% "play-json" % "2.6.9"
val gigahorse = "com.eed3si9n" %% "gigahorse-okhttp" % "0.3.1"


lazy val root = (project in file("."))
  .aggregate(core)
  .dependsOn(core)
  .enablePlugins(JavaAppPackaging)
  .settings(
    name := "Hello",
    libraryDependencies += scalaTest % Test,  // The % is used to construct and Ivy module ID from strings
    // update / aggregate := false,
  )
lazy val core = project
  .settings(
    name := "Hello Core",
    libraryDependencies += scalaTest % Test,
    libraryDependencies ++= Seq(gigahorse, playJson),
  )
