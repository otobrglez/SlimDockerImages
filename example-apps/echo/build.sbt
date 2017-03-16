name := "echo"

version := "1.0"

scalaVersion := "2.12.1"

resolvers ++= Seq(
  Resolver.sonatypeRepo("releases"),
  Resolver.sonatypeRepo("snapshots")
)

libraryDependencies ++= Seq(
  "com.typesafe.akka" %% "akka-actor" % "2.4.17",
  "com.typesafe.akka" %% "akka-slf4j" % "2.4.17",
  "com.typesafe.akka" %% "akka-http" % "10.0.4",

  "com.typesafe.scala-logging" %% "scala-logging" % "3.5.0",
  "ch.qos.logback" % "logback-classic" % "1.1.7",

  "com.typesafe.akka" %% "akka-http-spray-json" % "10.0.4",
  "com.typesafe.akka" %% "akka-http-testkit" % "10.0.4",

  "org.scalatest" %% "scalatest" % "3.0.1" % "test"
)

fork in run := true

assemblyJarName in assembly := "echo.jar"
mainClass in assembly := Some("EchoApp")

scalacOptions ++= Seq(
  "-deprecation",
  "-unchecked",
  "-Xfatal-warnings",
  "-feature",
  "-language:_",
  "-encoding", "utf8"
)

// Revolver.settings