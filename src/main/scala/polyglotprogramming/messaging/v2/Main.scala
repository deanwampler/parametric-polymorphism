package polyglotprogramming.messaging.v2
import polyglotprogramming.messaging.*
import polyglotprogramming.messaging.v2.given

object Processor:
  def apply[IM <: IncomingMessage](message: IM)(using handler: MessageHandler[IM]): OutgoingMessage =
    handler(message)
@main def Messaging() =
  println(Processor(IncomingMessage.Start("start")))
  println(Processor(IncomingMessage.DoWork1("dowork1")))
  println(Processor(IncomingMessage.DoWork2("dowork2")))
  println(Processor(IncomingMessage.Stop("stop")))
