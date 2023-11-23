package lila.fishnet

import cats.syntax.all.*
import ciris.*
import ciris.http4s.*
import com.comcast.ip4s.*
import cats.effect.IO

object Config:

  def load: IO[AppConfig] = appConfig.load[IO]

  def appConfig = (
    RedisConfig.config,
    HttpServerConfig.config,
    KamonConfig.config
  ).parMapN(AppConfig.apply)

case class AppConfig(redis: RedisConfig, server: HttpServerConfig, kamon: KamonConfig)

case class HttpServerConfig(host: Host, port: Port)

object HttpServerConfig:
  def host   = env("HTTP_HOST").or(prop("http.host")).as[Host].default(ip"127.0.0.1")
  def port   = env("HTTP_PORT").or(prop("http.port")).as[Port].default(port"9665")
  def config = (host, port).parMapN(HttpServerConfig.apply)

case class RedisConfig(host: Host, port: Port)

object RedisConfig:
  private def host = env("REDIS_HOST").or(prop("redis.host")).as[Host].default(ip"127.0.0.1")
  private def port = env("REDIS_PORT").or(prop("redis.port")).as[Port].default(port"6379")
  def config       = (host, port).parMapN(RedisConfig.apply)

case class KamonConfig(enabled: Boolean)

object KamonConfig:
  def config =
    env("KAMON_ENABLED").or(prop("kamon.enabled")).as[Boolean].default(false).map(KamonConfig.apply)
