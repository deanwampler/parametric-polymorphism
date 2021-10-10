package polyglotprogramming.messaging.v2
import polyglotprogramming.messaging.*

trait MessageHandler[IM <: IncomingMessage]:
  def apply(message: IM): OutgoingMessage =
    println(s"Received message: $message")
    OutgoingMessage.Succeeded(s"Successfully processed $message")

given MessageHandler[IncomingMessage.Start]()
given MessageHandler[IncomingMessage.DoWork1]()
given MessageHandler[IncomingMessage.DoWork2]()
given MessageHandler[IncomingMessage.Stop]()
