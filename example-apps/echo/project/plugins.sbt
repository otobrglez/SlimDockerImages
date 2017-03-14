logLevel := Level.Warn

resolvers += Resolver.sonatypeRepo("releases")

// addSbtPlugin("io.spray" % "sbt-revolver" % "0.7.2")

addSbtPlugin("com.eed3si9n" % "sbt-assembly" % "0.14.4")

addSbtPlugin("io.spray" % "sbt-revolver" % "0.8.0")