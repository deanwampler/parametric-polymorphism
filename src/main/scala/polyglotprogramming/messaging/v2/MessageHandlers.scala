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

// Using enums to define the message types, rather than using a parent trait and
// derived case classes causes one problem. If you comment out the following given
// definition, the first four lines in the Main.scala method "Messaging" fail to
// compile with errors like this:
//   [error] 10 |  println(Processor(IncomingMessage.Start("start")))
//   [error]    |                                                   ^
//   [error]    |no implicit argument of type polyglotprogramming.messaging.v2.MessageHandler[
//   [error]    |  polyglotprogramming.messaging.IncomingMessage
//   [error]    |] was found for parameter handler of method apply in object Processor
// The reason is that IncomingMessage.Start is still typed as IncomingMessage for
// the purposes of resolving the using clause, but I only defined givens above for
// the each of the specific message types (cases) inside IncomingMessage, not for
// IncomingMessage itself. Having to define the following given is ugly, but
// necessary in this case.
given MessageHandler[IncomingMessage] = new MessageHandler[IncomingMessage]:
  override def apply(message: IncomingMessage): OutgoingMessage = message match
    case IncomingMessage.Start(details)   => summon[MessageHandler[IncomingMessage.Start]](message.asInstanceOf[IncomingMessage.Start])
    case IncomingMessage.DoWork1(details) => summon[MessageHandler[IncomingMessage.DoWork1]](message.asInstanceOf[IncomingMessage.DoWork1])
    case IncomingMessage.DoWork2(details) => summon[MessageHandler[IncomingMessage.DoWork2]](message.asInstanceOf[IncomingMessage.DoWork2])
    case IncomingMessage.Stop(details)    => summon[MessageHandler[IncomingMessage.Stop]](message.asInstanceOf[IncomingMessage.Stop])
