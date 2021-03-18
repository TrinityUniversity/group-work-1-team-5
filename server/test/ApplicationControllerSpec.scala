import controllers.Application
import org.scalatestplus.play._
import play.api.test.Helpers
import play.api.test.Helpers._
import play.api.test.FakeRequest

class ApplicationControllerSpec extends PlaySpec {

  "ApplicationController" should {
    val controller = new Application(Helpers.stubControllerComponents())
    "render the index" in {
      val result = controller.index.apply(FakeRequest())
      val bodyText = contentAsString(result)
      bodyText must include ("It works!")
    }
  }

  // "Application" should {

  //   "send 404 on a bad request" in new WithApplication {
  //     route(app, FakeRequest(GET, "/boum")) must beSome.which (status(_) == NOT_FOUND)
  //   }

  //   "render the index page" in new WithApplication {
  //     val home = route(app, FakeRequest(GET, "/")).get

  //     status(home) must equalTo(OK)
  //     contentType(home) must beSome.which(_ == "text/html")
  //     contentAsString(home) must contain ("shouts out")
  //   }

    
  // }
}
