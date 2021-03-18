package controllers

import javax.inject._

import edu.trinity.videoquizreact.shared.SharedMessages
import play.api.mvc._

@Singleton
class FormController @Inject()(cc: ControllerComponents) extends AbstractController(cc) {

  def forms = Action { implicit request =>
    Ok(views.html.forms())
  }

  def getFormBasicText(name: String, favColor: String) = Action {
    // Ok(s"$name has the favorite color $favColor.")
    Ok(views.html.basicTextGet(favColor, name))
  }

  def postFormBasicText = Action { request =>
    val postVals = request.body.asFormUrlEncoded
    postVals.map { args =>
      val username = args("username").head
      Ok(views.html.basicTextPost(username))
    }.getOrElse(Ok("data pls"))
  }
  
}
