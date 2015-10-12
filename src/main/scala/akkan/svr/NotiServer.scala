package akkan.svr

import akkan.mdl.Notification
import akkan.svr.NotiTcpServer._

object NotiServer {
	def apply(host: String, port: Int) = new NotiServer(host, port)
}

class NotiServer (var host: String, var port: Int){
	val tcpServer = NotiTcpServer(host,port)

	def start() {
		tcpServer ! Start()
		//
		Thread.sleep(100000) //just for test, temprorayly.
	}

	def stop() {
		tcpServer ! Stop()
	}

	def sendNotification(noti: Notification) {

	}
}