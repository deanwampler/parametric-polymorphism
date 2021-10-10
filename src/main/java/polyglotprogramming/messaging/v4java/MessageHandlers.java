package polyglotprogramming.messaging.v4java;
import polyglotprogramming.messaging.v4java.Messages.*;

class MessageHandlers {
  public static MessageHandler<Start> startMessageHandler = new MessageHandler<Start>() {
    protected OutgoingMessage process(Start message) {
      return success("started");
    }
  };

  public static MessageHandler<DoWork1> doWork1MessageHandler = new MessageHandler<DoWork1>() {
    protected OutgoingMessage process(DoWork1 message) {
      return success("work1");
    }
  };

  public static MessageHandler<DoWork2> doWork2MessageHandler = new MessageHandler<DoWork2>() {
    protected OutgoingMessage process(DoWork2 message) {
      return failed("work2");
    }
  };

  public static MessageHandler<Stop> stopMessageHandler = new MessageHandler<Stop>() {
    protected OutgoingMessage process(Stop message) {
      return success("stopped");
    }
  };
}
