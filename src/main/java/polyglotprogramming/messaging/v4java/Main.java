package polyglotprogramming.messaging.v4java;
import polyglotprogramming.messaging.v4java.Messages.*;

class Main {
  public static class Processor<IM> {
    private MessageHandler<IM> handler = null;

    public Processor(MessageHandler<IM> handler) {
      this.handler = handler;
    }
    public OutgoingMessage apply(IM message) {
      return handler.apply(message);
    }
  }

  /** Add a new message type! */
  public static class DoWork3 extends IncomingMessage {
    public DoWork3(String details) {
      this.details = details;
    }
  }

  /** Also add a new handler for it. */
  public static MessageHandler<DoWork3> doWork3MessageHandler = new MessageHandler<DoWork3>() {
    protected OutgoingMessage process(DoWork3 message) {
      return success("work3");
    }
  };

  public static void main(String[] args) {
    Processor<Start>   startProcessor   = new Processor<Start>(MessageHandlers.startMessageHandler);
    Processor<DoWork1> doWork1Processor = new Processor<DoWork1>(MessageHandlers.doWork1MessageHandler);
    Processor<DoWork2> doWork2Processor = new Processor<DoWork2>(MessageHandlers.doWork2MessageHandler);
    Processor<DoWork3> doWork3Processor = new Processor<DoWork3>(doWork3MessageHandler);
    Processor<Stop>    stopProcessor    = new Processor<Stop>(MessageHandlers.stopMessageHandler);
    System.out.println("Result: "+startProcessor.apply(new Start("start")));
    System.out.println("Result: "+doWork1Processor.apply(new DoWork1("dowork1")));
    System.out.println("Result: "+doWork2Processor.apply(new DoWork2("dowork2")));
    System.out.println("Result: "+doWork3Processor.apply(new DoWork3("dowork3")));
    System.out.println("Result: "+stopProcessor.apply(new Stop("stop")));
  }
}
