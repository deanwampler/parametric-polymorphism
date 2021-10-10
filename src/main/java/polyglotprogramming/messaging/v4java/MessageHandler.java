package polyglotprogramming.messaging.v4java;
import polyglotprogramming.messaging.v4java.Messages.*;

abstract class MessageHandler<IM> {
  public OutgoingMessage apply(IM message) {
    System.out.println("Received message: "+message);
    return process(message);
  }

  abstract protected OutgoingMessage process(IM message);

  protected OutgoingMessage success(String response) {
    return new Succeeded(response);
  }
  protected OutgoingMessage failed(String response) {
    return new Failed(response);
  }
}
