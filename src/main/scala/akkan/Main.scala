package akkan

import akkan.svr.Logger
import akkan.svr.NotiServer
import akkan.svr.NotiTcpServer

object Main extends App {
	
	Logger.debug("akka notification server")

	val notiServer = NotiServer("localhost", 6000)

	notiServer.start()
	Logger.debug("started noti server")

	notiServer.stop()
	Logger.debug("stopped noti server")
}