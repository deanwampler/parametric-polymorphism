package polyglotprogramming.messaging

/**
 * Use a parent trait and case class subtypes. I don't use "sealed" for the
 * IncomingMessage types, because in v4 I'll show how nicely we can add
 * new message types with minimal, yet robust code changes.
 *
 * I could have used an enum instead here, but doing so causes some typing issues
 * in the v2 through v4 implementations. See the code comments in the v2
 * implementation in the git branch "with-enums" for details.
 *
 * @param details string as a simple way of returning information.
 */
trait IncomingMessage(details: String)
case class Start(details: String)   extends IncomingMessage(details)
case class DoWork1(details: String) extends IncomingMessage(details)
case class DoWork2(details: String) extends IncomingMessage(details)
case class Stop(details: String)    extends IncomingMessage(details)

/** Here I'll assume we only need to return message types. */
sealed trait OutgoingMessage(details: String)
case class Succeeded(details: String) extends OutgoingMessage(details)
case class Failed(details: String)    extends OutgoingMessage(details)
