import akka.actor.{Actor, ActorSystem}
import akka.stream.ActorMaterializer
import akka.http.scaladsl.Http
import akka.http.scaladsl.server.Directives._

import scala.concurrent.{ExecutionContextExecutor, Future}
import com.typesafe.config.Config
import com.typesafe.config.ConfigFactory
import akka.event.{Logging, LoggingAdapter}
import akka.http.scaladsl.marshallers.sprayjson.SprayJsonSupport
import akka.http.scaladsl.model.DateTime
import spray.json._

trait Service extends SprayJsonSupport with DefaultJsonProtocol {
  implicit val system: ActorSystem
  implicit val executor: ExecutionContextExecutor
  implicit val materializer: ActorMaterializer

  def config: Config

  val logger: LoggingAdapter

  val routes = {
    logRequest("echoAppService", Logging.DebugLevel) {
      get {
        parameters('name.as[String] ? "World") { (name) =>
          complete(Map[String, String](
            "hello" -> s"Hey, ${name}!",
            "created_at" -> DateTime.now.toIsoDateTimeString()
          ))
        }
      }
    }
  }
}

object EchoApp extends App with Service {
  override implicit val system = ActorSystem("echoServer")
  override implicit val executor = system.dispatcher
  override implicit val materializer = ActorMaterializer()
  override val config = ConfigFactory.load()
  override val logger = Logging(system, getClass)

  val Array(address, port) = Array(config.getString("http.interface"), config.getInt("http.port"))
  Http().bindAndHandle(routes, address.asInstanceOf[String], port.asInstanceOf[Int])
    .onComplete(_ => {
      logger.info(s"Started on ${address}:${port}")
    })
}
