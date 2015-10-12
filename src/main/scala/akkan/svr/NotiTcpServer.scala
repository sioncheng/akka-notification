package akkan.svr

import akka.io.{IO,Tcp}
import akka.actor.{Actor, ActorRef, Props, ActorSystem}
import akka.util.ByteString
import java.net.InetSocketAddress

object NotiTcpServer {
	case class Start()
	case class Stop()

	def apply(host:String, port:Int) = {
		val system = ActorSystem("NotiTcpServer")
		system.actorOf(Props(new NotiTcpServer(host,port)))
	}
}


class NotiTcpServer(val host:String, val port:Int)
	extends Actor {
	//
	import NotiTcpServer._
	import Tcp._
	import context.system

	def receive = {
		case s @ Start() =>
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