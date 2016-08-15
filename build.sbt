lazy val root = (project in file(".")).
  settings(
    organization := "cat.dvmlls",
    version := "0.0.0",
    scalaVersion := "2.11.8",
    sourcesInBase := false,
    scalacOptions ++= Seq("-deprecation", "-feature", "-target:jvm-1.7"),
    javacOptions in Compile ++= "-source" :: "1.7" :: "-target" :: "1.7" :: Nil,
    name := "farts",
    androidBuild,
    platformTarget in Android := "android-19",
    buildToolsVersion in Android := Some("19.1.0"),
    libraryDependencies ++= Seq(
      "org.slf4j" % "slf4j-simple" % "1.7.12",
      "org.scalatest" %% "scalatest" % "2.2.1" % "test",
      "junit" % "junit" % "4.12" % "test"
    )
  )


