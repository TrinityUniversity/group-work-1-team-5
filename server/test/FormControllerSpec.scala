import controllers.FormController
import org.scalatestplus.play._
import play.api.test.Helpers
import play.api.test.Helpers._
import play.api.test.FakeRequest

class FormControllerSpec extends PlaySpec {

  "FormController" should {
    val controller = new FormController(Helpers.stubControllerComponents())
    "render the get form" in {
      val result = controller.getForm.apply(FakeRequest())
      val bodyText = contentAsString(result)
      bodyText must include ("Favorite Color GET")
      bodyText must include ("Username POST")
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
