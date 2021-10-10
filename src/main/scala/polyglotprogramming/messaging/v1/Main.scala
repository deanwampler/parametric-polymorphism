package polyglotprogramming.messaging.v1
import polyglotprogramming.messaging.*

object Processor:
  def apply(message: IncomingMessage): OutgoingMessage = message match
    case IncomingMessage.Start(details)   => StartHandler(message.asInstanceOf[IncomingMessage.Start])
    case IncomingMessage.DoWork1(details) => DoWork1Handler(message.asInstanceOf[IncomingMessage.DoWork1])
    case IncomingMessage.DoWork2(details) => DoWork2Handler(message.asInstanceOf[IncomingMessage.DoWork2])
    case IncomingMessage.Stop(details)    => StopHandler(message.asInstanceOf[IncomingMessage.Stop])

@main def Messaging() =
  Seq(IncomingMessage.Start("start"),
      IncomingMessage.DoWork1("dowork1"),
      IncomingMessage.DoWork2("dowork2"),
      IncomingMessage.Stop("stop")).foreach { message =>
    println(Processor(message))
  }
