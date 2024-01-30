import sbt.*

object Dependencies {

  val lilaMaven = "lila-maven" at "https://raw.githubusercontent.com/lichess-org/lila-maven/master"

  object V {
    val circe      = "0.14.6"
    val http4s     = "0.23.25"
    val ciris      = "3.5.0"
    val kamon      = "2.5.11"
    val kamonAgent = "1.0.18"
    val chess      = "15.7.1"
    val catsEffect = "3.5.3"
  }

  def http4s(artifact: String) = "org.http4s" %% s"http4s-$artifact" % V.http4s
  def circe(artifact: String)  = "io.circe"   %% s"circe-$artifact"  % V.circe

  val chess = "org.lichess" %% "scalachess" % V.chess

  val catsCore   = "org.typelevel" %% "cats-core"   % "2.10.0"
  val catsEffect = "org.typelevel" %% "cats-effect" % V.catsEffect

  val circeCore    = circe("core")
  val circeLiteral = circe("literal") % Test

  val cirisCore    = "is.cir" %% "ciris"         % V.ciris
  val cirisHtt4s   = "is.cir" %% "ciris-http4s"  % V.ciris
  val cirisRefined = "is.cir" %% "ciris-refined" % V.ciris

  val kamonCore          = "io.kamon" %% "kamon-core"           % V.kamon
  val kamonInflux        = "io.kamon" %% "kamon-influxdb"       % V.kamon
  val kamonSystemMetrics = "io.kamon" %% "kamon-system-metrics" % V.kamon
  val kamonAgent         = "io.kamon"  % "kanela-agent"         % V.kamonAgent

  val http4sDsl    = http4s("dsl")
  val http4sServer = http4s("ember-server")
  val http4sClient = http4s("ember-client") % Test
  val http4sCirce  = http4s("circe")

  val log4Cats = "org.typelevel" %% "log4cats-slf4j"  % "2.6.0"
  val logback  = "ch.qos.logback" % "logback-classic" % "1.4.14"

  val redis = "io.chrisdavenport" %% "rediculous" % "0.5.1"

  val chessTestKit      = "org.lichess"         %% "scalachess-test-kit"       % V.chess      % Test
  val log4CatsNoop      = "org.typelevel"       %% "log4cats-noop"             % "2.6.0"      % Test
  val testContainers    = "com.dimafeng"        %% "testcontainers-scala-core" % "0.41.2"     % Test
  val weaver            = "com.disneystreaming" %% "weaver-cats"               % "0.8.4"      % Test
  val weaverScalaCheck  = "com.disneystreaming" %% "weaver-scalacheck"         % "0.8.4"      % Test
  val catsEffectTestKit = "org.typelevel"       %% "cats-effect-testkit"       % V.catsEffect % Test
}
