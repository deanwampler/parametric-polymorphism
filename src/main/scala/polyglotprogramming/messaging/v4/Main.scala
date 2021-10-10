package polyglotprogramming.messaging.v4
import polyglotprogramming.messaging.*
import polyglotprogramming.messaging.v4.given

object Processor:
  def apply[IM <: IncomingMessage](message: IM)(using handler: MessageHandler[IM]): OutgoingMessage =
    handler(message)

/**
 * Add a new message type!
 */
case class DoWork3(details: String) extends IncomingMessage(details)

/**
 * Also, a custom given instance is required for it.
 * Try commenting out this definition; you'll get a compilation error!
 */
given MessageHandler[DoWork3] with
  protected def process(message: DoWork3): OutgoingMessage = success("work3")

@main def Messaging() =
  println(Processor(Start("start")))
  println(Processor(DoWork1("dowork1")))
  println(Processor(DoWork2("dowork2")))
  println(Processor(DoWork3("dowork3")))
  println(Processor(Stop("stop")))
