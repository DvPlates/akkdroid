lazy val root = (project in file(".")).
  settings(
    name := "farts",
    organization := "cat.dvmlls",
    version := "0.0.0",
    scalaVersion := "2.11.8",
    sourcesInBase := false,
    scalacOptions ++= Seq("-deprecation", "-feature", "-target:jvm-1.7"),
    javacOptions in Compile ++= Seq("-source", "1.7", "-target", "1.7"),
    libraryDependencies ++= Seq(
      "com.typesafe.akka" %% "akka-actor" % "2.3.15",
      "com.typesafe.akka" %% "akka-slf4j" % "2.3.15",
      "org.slf4j" % "slf4j-simple" % "1.7.12",
      "org.scalatest" %% "scalatest" % "2.2.1" % "test",
      "junit" % "junit" % "4.12" % "test"
    ),
    androidBuild,
    platformTarget in Android := "android-19",
    buildToolsVersion in Android := Some("19.1.0"),
    proguardScala in Android := true,
    proguardOptions in Android ++= Seq(
      "-keep class scala.Dynamic",
      "-keepattributes InnerClasses"
    ),
    proguardOptions in Android ++= Seq( // akka - copied from macroid
      "-dontwarn sun.misc.Unsafe",
      "-keep class akka.actor.Actor$class { *; }",
      "-keep class akka.actor.LightArrayRevolverScheduler { *; }",
      "-keep class akka.actor.LocalActorRefProvider { *; }",
      "-keep class akka.actor.CreatorFunctionConsumer { *; }",
      "-keep class akka.actor.TypedCreatorFunctionConsumer { *; }",
      "-keep class akka.dispatch.BoundedDequeBasedMessageQueueSemantics { *; }",
      "-keep class akka.dispatch.UnboundedMessageQueueSemantics { *; }",
      "-keep class akka.dispatch.UnboundedDequeBasedMessageQueueSemantics { *; }",
      "-keep class akka.dispatch.DequeBasedMessageQueueSemantics { *; }",
      "-keep class akka.dispatch.MultipleConsumerSemantics { *; }",
      "-keep class akka.actor.LocalActorRefProvider$Guardian { *; }",
      "-keep class akka.actor.LocalActorRefProvider$SystemGuardian { *; }",
      "-keep class akka.dispatch.UnboundedMailbox { *; }",
      "-keep class akka.actor.DefaultSupervisorStrategy { *; }",
      "-keep class akka.event.Logging$LogExt { *; }"
    ),
    proguardOptions in Android ++= Seq(
      "-dontwarn scoverage.Invoker$"
    )
  )
