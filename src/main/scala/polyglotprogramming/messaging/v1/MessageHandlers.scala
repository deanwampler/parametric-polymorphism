package polyglotprogramming.messaging.v1
import polyglotprogramming.messaging.*

trait MessageHandler[IM <: IncomingMessage]:
  def apply(message: IM): OutgoingMessage

case object StartHandler extends MessageHandler[Start]:
  def apply(message: Start): OutgoingMessage =
    println(s"Received message: $message")
    Succeeded(s"Successfully processed $message")

case object DoWork1Handler extends MessageHandler[DoWork1]:
  def apply(message: DoWork1): OutgoingMessage =
    println(s"Received message: $message")
    Succeeded(s"Successfully processed $message")

case object DoWork2Handler extends MessageHandler[DoWork2]:
  def apply(message: DoWork2): OutgoingMessage =
    println(s"Received message: $message")
    Succeeded(s"Successfully processed $message")

case object StopHandler extends MessageHandler[Stop]:
  def apply(message: Stop): OutgoingMessage =
    println(s"Received message: $message")
    Succeeded(s"Successfully processed $message")
