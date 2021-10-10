package polyglotprogramming.messaging.v1
import polyglotprogramming.messaging.*

object Processor:
  def apply(message: IncomingMessage): OutgoingMessage = message match
    case Start(details)   => StartHandler(message.asInstanceOf[Start])
    case DoWork1(details) => DoWork1Handler(message.asInstanceOf[DoWork1])
    case DoWork2(details) => DoWork2Handler(message.asInstanceOf[DoWork2])
    case Stop(details)    => StopHandler(message.asInstanceOf[Stop])

@main def Messaging() =
  Seq(Start("start"),
      DoWork1("dowork1"),
      DoWork2("dowork2"),
      Stop("stop")).foreach { message =>
    println(Processor(message))
  }
