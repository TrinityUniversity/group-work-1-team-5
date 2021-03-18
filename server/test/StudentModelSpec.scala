import models.StudentModel
import org.scalatestplus.play._
import play.api.test.Helpers
import play.api.test.Helpers._

class StudentModelSpec extends PlaySpec {
  "StudentModel" should {
    "get correct friends for user" in {
      val username = "khardee"
      val friends = StudentModel.getFriends(username)
      // Kurt Hardee,pabila,mcartwri,rfernan3,thall,jkibet,jrosser,awalker3
      //println("friends is" + friends)
      friends must not be (Nil)
      friends must contain ("pabila")
      friends must contain ("mcartwri")
      friends must contain ("rfernan3")
      friends must contain ("thall")
      friends must contain ("jkibet")
      friends must contain ("jrosser")
      //friends must contain ("awalker3")
      friends mustBe (Seq("pabila","mcartwri","rfernan3","thall","jkibet","jrosser"))
    }
  }
}