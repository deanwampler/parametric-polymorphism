package polyglotprogramming.messaging.v3
import polyglotprogramming.messaging.*

trait MessageHandler[IM <: IncomingMessage]:
  def apply(message: IM): OutgoingMessage =
    println(s"Received message: $message")
    process(message)

  protected def process(message: IM): OutgoingMessage

  protected def success(response: String) = Succeeded(response)
  protected def failure(response: String) = Failed(response)

given MessageHandler[Start] with
  protected def process(message: Start): OutgoingMessage = success("started")

given MessageHandler[DoWork1] with
  protected def process(message: DoWork1): OutgoingMessage = success("work1")

given MessageHandler[DoWork2] with
  protected def process(message: DoWork2): OutgoingMessage = failure("work2")

given MessageHandler[Stop] with
  protected def process(message: Stop): OutgoingMessage = success("stopped")
