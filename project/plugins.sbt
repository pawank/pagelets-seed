scalacOptions ++= Seq( "-unchecked", "-deprecation" )

resolvers += Resolver.typesafeRepo("releases")

resolvers += Resolver.url("jetbrains-bintray", url("http://dl.bintray.com/jetbrains/sbt-plugins/"))(Resolver.ivyStylePatterns)

resolvers += "micronautics/scala on bintray" at "http://dl.bintray.com/micronautics/scala"

// The Play plugin
addSbtPlugin("com.typesafe.play" % "sbt-plugin" % "2.6.11")

// web plugins
addSbtPlugin("com.typesafe.sbt" % "sbt-less" % "1.1.2")
addSbtPlugin("com.typesafe.sbt" % "sbt-jshint" % "1.0.6")
addSbtPlugin("com.typesafe.sbt" % "sbt-digest" % "1.1.3")
addSbtPlugin("com.typesafe.sbt" % "sbt-uglify" % "2.0.0")

// swagger
addSbtPlugin("com.iheart" %% "sbt-play-swagger" % "0.7.3")


addCompilerPlugin("org.scalamacros" % "paradise" % "2.1.0" cross CrossVersion.full)
