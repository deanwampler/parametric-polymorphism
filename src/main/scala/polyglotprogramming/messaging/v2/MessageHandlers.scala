package polyglotprogramming.messaging.v2
import polyglotprogramming.messaging.*

trait MessageHandler[IM <: IncomingMessage]:
  def apply(message: IM): OutgoingMessage =
    println(s"Received message: $message")
    Succeeded(s"Successfully processed $message")

given MessageHandler[Start]()
given MessageHandler[DoWork1]()
given MessageHandler[DoWork2]()
given MessageHandler[Stop]()
