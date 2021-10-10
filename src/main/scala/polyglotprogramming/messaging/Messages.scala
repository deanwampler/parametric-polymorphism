package polyglotprogramming.messaging

enum IncomingMessage(details: String):
  case Start(details: String)   extends IncomingMessage(details)
  case DoWork1(details: String) extends IncomingMessage(details)
  case DoWork2(details: String) extends IncomingMessage(details)
  case Stop(details: String)    extends IncomingMessage(details)

enum OutgoingMessage(details: String):
  case Succeeded(details: String) extends OutgoingMessage(details)
  case Failed(details: String)    extends OutgoingMessage(details)
