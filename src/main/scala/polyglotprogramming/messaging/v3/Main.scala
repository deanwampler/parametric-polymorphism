package polyglotprogramming.messaging.v3
import polyglotprogramming.messaging.*
import polyglotprogramming.messaging.v3.given

object Processor:
  def apply[IM <: IncomingMessage](message: IM)(using handler: MessageHandler[IM]): OutgoingMessage =
    handler(message)

@main def Messaging() =
  println(Processor(Start("start")))
  println(Processor(DoWork1("dowork1")))
  println(Processor(DoWork2("dowork2")))
  println(Processor(Stop("stop")))
