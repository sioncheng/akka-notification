package akkan.mdl

import spray.json._

object Notification {
	def apply(title: String, content: String, extention: JsValue) = 
		new Notification(title,content,extention)
}

class Notification (var title: String,
	var content: String,
	var extention: JsValue) {

}