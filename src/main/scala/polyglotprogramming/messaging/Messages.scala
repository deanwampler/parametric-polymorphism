package polyglotprogramming.messaging

trait IncomingMessage(details: String)
case class Start(details: String)   extends IncomingMessage(details)
case class DoWork1(details: String) extends IncomingMessage(details)
case class DoWork2(details: String) extends IncomingMessage(details)
case class Stop(details: String)    extends IncomingMessage(details)

trait OutgoingMessage(details: String)
case class Succeeded(details: String) extends OutgoingMessage(details)
case class Failed(details: String)    extends OutgoingMessage(details)
