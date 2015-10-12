package akkan.svr

object Logger {
	def debug(msg: String) {
		println("[debug] " + msg)
	}

	def info(msg: String) {
		println("[info]  " + msg)
	}

	def warn(msg: String) {
		println("[warn]  " + msg)
	}

	def error(msg: String) {
		println("[error] " + msg)
	}
}