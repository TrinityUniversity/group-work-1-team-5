package controllers

import javax.inject._

import edu.trinity.videoquizreact.shared.SharedMessages
import play.api.mvc._

@Singleton
class TestText @Inject()(cc: ControllerComponents) extends AbstractController(cc) {

  def testtext = Action {
    Ok(views.html.testtext(SharedMessages.testText))
  }

}
