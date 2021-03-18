package controllers

import javax.inject._
import play.api.mvc._
import models.StudentModel

@Singleton
class FormController @Inject()(cc: ControllerComponents) extends AbstractController(cc) {

  def forms = Action { implicit request =>
    Ok(views.html.forms())
  }

  def getFormBasicText(name: String, favColor: String) = Action {
    // Ok(s"$name has the favorite color $favColor.")
    Ok(views.html.basicTextGet(favColor, name))
  }

  def validateUser = Action { request =>
    val postVals = request.body.asFormUrlEncoded
    postVals.map { args =>
      val username = args("username").head

      if (StudentModel.validateUsername(username)) {
        Redirect(routes.FormController.studentInfo()).withSession("username" -> username)
      } else Redirect(routes.FormController.forms())
    }.getOrElse(Ok("data pls"))
  }

  def studentInfo = Action { request =>
    request.session.get("username").map { username =>
      val friends = StudentModel.getFriends(username)
      val pageInfo = StudentModel.getPageInfo(username)

      Ok(views.html.studentInfo(username, friends, pageInfo)).withSession("username" -> username)
    }.getOrElse(Redirect(routes.FormController.forms()))
  }

  def logout = Action {
    Redirect(routes.FormController.forms()).withNewSession
  }
  
}
