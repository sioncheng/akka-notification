package akkan.svr

import akka.io.{IO,Tcp}
import akka.actor.{Actor, ActorRef, Props, ActorSystem}
import akka.util.ByteString
import java.net.InetSocketAddress

object NotiTcpServer {
	case class Start(host:String, port:Int)
	case class Stop()

	def apply() = {
		val system = ActorSystem("NotiTcpServer")
		system.actorOf(Props[NotiTcpServer])
	}
}


class NotiTcpServer extends Actor {
	import NotiTcpServer._
	import Tcp._
	import context.system

	def receive = {
		case s @ Start(host,port) =>
			IO(Tcp) ! Bind(self, new InetSocketAddress(host, port))
		case b @ Bound(localAddress) =>
			Logger.debug("bound " + localAddress)
		case c @ Connected(remote, local) =>
			Logger.debug("connected " + remote + "," + local)
			val conn = sender()
			val clientHandler = context.actorOf(Props(TcpClientHandler(remote)))
			conn ! Register(clientHandler)
	}
}