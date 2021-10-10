package polyglotprogramming.messaging.v1
import polyglotprogramming.messaging.*

trait MessageHandler[IM <: IncomingMessage]:
  def apply(message: IM): OutgoingMessage

case object StartHandler extends MessageHandler[IncomingMessage.Start]:
  def apply(message: IncomingMessage.Start): OutgoingMessage =
    println(s"Received message: $message")
    OutgoingMessage.Succeeded(s"Successfully processed $message")

case object DoWork1Handler extends MessageHandler[IncomingMessage.DoWork1]:
  def apply(message: IncomingMessage.DoWork1): OutgoingMessage =
    println(s"Received message: $message")
    OutgoingMessage.Succeeded(s"Successfully processed $message")

case object DoWork2Handler extends MessageHandler[IncomingMessage.DoWork2]:
  def apply(message: IncomingMessage.DoWork2): OutgoingMessage =
    println(s"Received message: $message")
    OutgoingMessage.Succeeded(s"Successfully processed $message")

case object StopHandler extends MessageHandler[IncomingMessage.Stop]:
  def apply(message: IncomingMessage.Stop): OutgoingMessage =
    println(s"Received message: $message")
    OutgoingMessage.Succeeded(s"Successfully processed $message")
