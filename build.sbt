import sbt.Keys._

name := """pagelets-seed"""

version := "0.1"

val scalaVer = "2.12.4"

lazy val commonSettings = Seq(
  version := "1.0",
  scalaVersion := scalaVer,
  scalacOptions ++= Seq(
    "-target:jvm-1.8"
    , "-feature"
    , "-deprecation"
    //, "-Xfatal-warnings"
    , "-Xmax-classfile-name", "100"
    , "-unchecked"
    , "-language:implicitConversions"
    , "-language:reflectiveCalls"
    , "-language:postfixOps"
    , "-language:higherKinds"
    , "-encoding", "UTF-8"
    , "-Yno-adapted-args"
    , "-Xlint"
    , "-Ywarn-numeric-widen"
    , "-Ywarn-value-discard"
    , "-Xfuture"
    //    , "-Xlog-implicits"
  ),
  javacOptions ++= Seq("-source", "1.8", "-target", "1.8", "-Xlint"),
  resolvers ++= Seq(
    Resolver.sonatypeRepo("snapshots"),"micronautics/scala on bintray" at "http://dl.bintray.com/micronautics/scala"
  )
)


lazy val macrosModule = project.in(file("macros"))
  .settings(commonSettings: _*)
  .settings(
    libraryDependencies ++= Seq(
      "org.scala-lang" % "scala-reflect",
      "org.scala-lang" % "scala-compiler"
    ).map(_  % scalaVer),
    libraryDependencies ++= Seq(
      Dependencies.Database.postgres,
      Dependencies.Database.quillCore,
      Dependencies.Database.quillJdbc,
      Dependencies.Database.quillAsyncPostgresql,
    )
)

lazy val root = (project in file(".")).enablePlugins(PlayScala, SwaggerPlugin).
  settings(commonSettings: _*).
  settings(Seq(
    scalaVersion := scalaVer,
    routesImport += "org.splink.pagelets.Binders._"),
    libraryDependencies ++= Seq(
      "org.scala-lang" % "scala-reflect",
      "org.scala-lang" % "scala-compiler"
    ).map(_  % scalaVer),
    libraryDependencies ++= Seq(
      Dependencies.Play.ws,
      Dependencies.Play.guice,
      Dependencies.Web.pagelets,
      Dependencies.Web.scalaTestplus,
      Dependencies.Web.mockito,
      Dependencies.Web.logback,
      Dependencies.WebJars.bootstrap37,
      Dependencies.WebJars.jquery,
      Dependencies.Database.postgres,
      Dependencies.Database.quillCore,
      Dependencies.Database.quillJdbc,
      Dependencies.Database.quillAsyncPostgresql,
      Dependencies.Swagger.swagger
    )
  )//.dependsOn(macrosModule)

// to use streaming, HtmlStreamFormat is required
TwirlKeys.templateFormats ++= Map(
  "stream" -> "org.splink.pagelets.twirl.HtmlStreamFormat")

// auto-import the following types in templates
TwirlKeys.templateImports ++= Vector(
  "org.splink.pagelets.twirl.HtmlStream",
  "org.splink.pagelets.twirl.HtmlStreamFormat",
  "org.splink.pagelets.twirl.HtmlPageStream",
  "org.splink.pagelets.Page")


// enable asset minification
LessKeys.compress in Assets := true
LessKeys.optimization in Assets := 100

includeFilter in uglify := GlobFilter("*.js")
// also minify the bootstrap javascript files
excludeFilter in uglify := new SimpleFileFilter(f =>
  !f.getPath.contains("lib/bootstrap/js") &&
    !f.getPath.contains("assets/javascripts"))

includeFilter in(Assets, LessKeys.less) := "*.less"
excludeFilter in(Assets, LessKeys.less) := "_*.less"

pipelineStages in Assets := Seq(uglify)

swaggerDomainNameSpaces := Seq("models")
