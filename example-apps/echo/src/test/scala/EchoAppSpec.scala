import org.scalatest.{Matchers, WordSpec}
import akka.http.scaladsl.model.StatusCodes
import akka.http.scaladsl.testkit.ScalatestRouteTest
import akka.http.scaladsl.server._
import Directives._
import EchoApp.{getClass, _}
import akka.actor.ActorSystem
import akka.event.Logging
import akka.stream.ActorMaterializer
import com.typesafe.config.ConfigFactory

class EchoAppSpec extends WordSpec with Matchers with ScalatestRouteTest {

  object EchoAppService extends Service {
    override implicit val system = ActorSystem("echoServerTest")
    override implicit val executor = system.dispatcher
    override implicit val materializer = ActorMaterializer()
    override val logger = Logging(system, getClass)
    override val config = ConfigFactory.load()
  }

  "EchoApp service" should {
    "return something" in {
      Get() ~> EchoAppService.routes ~> check {
        responseAs[String] should include("World")
      }
    }

    "return name" in {
      Get("/?name=Oto") ~> EchoAppService.routes ~> check {
        responseAs[String] should include("Oto")
      }
    }
  }
}
