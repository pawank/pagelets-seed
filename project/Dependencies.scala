import sbt._

object Dependencies {
  object Play {
    private[this] val version = "2.6.11"
    val lib = "com.typesafe.play" %% "play" % version
    val filters = play.sbt.PlayImport.filters
    val ws = play.sbt.PlayImport.ws
    val guice = play.sbt.PlayImport.guice
    val cache = play.sbt.PlayImport.ehcache
    val json = "com.typesafe.play" %% "play-json" % version
    //val json = "com.typesafe.play" %% "play-json" % "2.6.8"
    val test = "com.typesafe.play" %% "play-test" % version % "test"
  }

  object Web {
    private[this] val version = "0.0.7"
    val pagelets = "org.splink" %% "pagelets" % version
    val scalaTestplus = "org.scalatestplus.play" %% "scalatestplus-play" % "3.1.2" % Test
    //"org.mockito" % "mockito-core" % "2.13.0" % Test,
    val mockito = "org.mockito" % "mockito-core" % "1.10.19" % Test
    val logback = "ch.qos.logback" % "logback-classic" % "1.2.3"
    val playGuard = "com.digitaltangible" %% "play-guard" % "2.1.0"
  }

  object Swagger {

    private[this] val version = "2.2.0"
    val swagger = "org.webjars" % "swagger-ui" % version
  }

  object Akka {
    private[this] val version = "2.5.9"
    val actor = "com.typesafe.akka" %% "akka-actor" % version
    val remote = "com.typesafe.akka" %% "akka-remote" % version
    val logging = "com.typesafe.akka" %% "akka-slf4j" % version
    val cluster = "com.typesafe.akka" %% "akka-cluster" % version
    val clusterMetrics = "com.typesafe.akka" %% "akka-cluster-metrics" % version
    val clusterTools = "com.typesafe.akka" %% "akka-cluster-tools" % version
    val visualMailbox = "de.aktey.akka.visualmailbox" %% "collector" % "1.1.0"
    val testkit = "com.typesafe.akka" %% "akka-testkit" % version % "test"
  }

  object Authentication {
    private[this] val version = "5.0.3"
    val silhouette = "com.mohiva" %% "play-silhouette" % version
    val hasher = "com.mohiva" %% "play-silhouette-password-bcrypt" % version
    val persistence = "com.mohiva" %% "play-silhouette-persistence" % version
    val crypto = "com.mohiva" %% "play-silhouette-crypto-jca" % version
  }

  object Database {
    val version = "3.2.1"

    val postgres = "org.postgresql" % "postgresql" % "9.4.1212"
    val hikariCp = "com.zaxxer" % "HikariCP" % "2.7.5"
    val slickCore = "com.typesafe.slick" %% "slick" % version
    val slickHikariCp = "com.typesafe.slick" %% "slick-hikaricp" % version
    val slickPg = "com.github.tminglei" %% "slick-pg" % "0.15.5"
    val slickPgCirce = "com.github.tminglei" %% "slick-pg_circe-json" % "0.15.5"

    val quillVersion = "2.3.2"
    val quillCore = "io.getquill" %% "quill-core" % quillVersion
    val quillJdbc = "io.getquill" %% "quill-jdbc" % quillVersion
    val quillAsyncPostgresql = "io.getquill" %% "quill-async-postgres" % quillVersion
  }

  object GraphQL {
    val sangria = "org.sangria-graphql" %% "sangria" % "1.3.3"
    val playJson = "org.sangria-graphql" %% "sangria-play-json" % "1.0.4"
    val circe = "org.sangria-graphql" %% "sangria-circe" % "1.2.0"
  }

  object Serialization {
    val circeVersion = "0.9.0"
  }

  object WebJars {
    val fontAwesome = "org.webjars" % "font-awesome" % "5.0.2"
    //val jquery = "org.webjars" % "jquery" % "2.2.4"
    val jquery = "org.webjars" % "jquery" % "3.1.1"
    val bootstrap37 = "org.webjars.bower" % "bootstrap" % "3.3.7"
    val materialize = "org.webjars" % "materializecss" % "0.100.2"
    val moment = "org.webjars" % "momentjs" % "2.20.1"
    val mousetrap = "org.webjars" % "mousetrap" % "1.6.0"
  }

  object Metrics {
    val version = "0.1.0"
    val metrics = "io.prometheus" % "simpleclient" % version
    val metricsJvm = "io.prometheus" % "simpleclient_hotspot" % version
    val metricsHttp = "io.prometheus" % "simpleclient_httpserver" % version
    val metricsPush = "io.prometheus" % "simpleclient_pushgateway" % version
  }

  object Tracing {
    private[this] val version = "4.6.0"
    val brave = "io.zipkin.brave" % "brave-core" % version
    val http = "io.zipkin.reporter" % "zipkin-sender-okhttp3" % "1.1.0"
    val logging = "io.zipkin.brave" % "brave-context-slf4j" % version
  }

  object ScalaJS {
    val scalaJSVersion = "0.6.21"
    val jQueryVersion = "0.9.2"
    val jvmStubs = "org.scala-js" %% "scalajs-stubs" % scalaJSVersion % "provided"
  }

  object Utils {
    val scapegoatVersion = "1.3.3"
    val enumeratumVersion = "1.5.15"
    val booPickleVersion = "1.2.5"
    val utestVersion = "0.6.3"

    val scalatagsVersion = "0.6.7"

    val csv = "com.github.tototoshi" %% "scala-csv" % "1.3.5"
    val betterFiles = "com.github.pathikrit" %% "better-files" % "3.4.0"
    val commonsIo = "commons-io" % "commons-io" % "2.6"
    val scalaGuice = "net.codingwell" %% "scala-guice" % "4.1.1"
  }

  object Testing {
    val scalaTest = "org.scalatest" %% "scalatest" % "3.0.4" % "test"
  }
}
