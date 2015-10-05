package akkan.mdl

import org.scalatest._
import spray.json._

class NotificationTest  extends FlatSpec with Matchers {
	"create notification" should "work" in {
		val extention = "{}".parseJson
		val noti = Notification("title","content",extention)

		noti.title should be ("title")
		noti.content should be ("content")
		noti.extention should be (extention)
	}
}