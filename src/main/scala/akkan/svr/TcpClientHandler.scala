package akkan.svr

import akka.io.{IO,Tcp}
import akka.actor.{Actor, ActorRef, Props}
import akka.util.ByteString
import java.net.InetSocketAddress

object TcpClientHandler {
	def apply(conn: InetSocketAddress) = new TcpClientHandler(conn)
}

class TcpClientHandler(var conn: InetSocketAddress) extends Actor {
	//
	import Tcp._

	def receive = {
		case Received(data) =>
			Logger.debug("received data" + data)
		case PeerClosed =>
			Logger.debug("peer closed" + conn)
	}
}