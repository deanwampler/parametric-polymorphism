package polyglotprogramming.messaging.v4java;

/** Java version of the message hierarchies */
public class Messages {
  public static abstract class IncomingMessage {
    public String details = null;
    public String toString() {
      return this.getClass().getName() + "(details = " + details + ")";
    }
  }
  public static class Start extends IncomingMessage {
    public Start(String details) {
      this.details = details;
    }
  }
  public static class DoWork1 extends IncomingMessage {
    public DoWork1(String details) {
      this.details = details;
    }
  }
  public static class DoWork2 extends IncomingMessage {
    public DoWork2(String details) {
      this.details = details;
    }
  }
  public static class Stop extends IncomingMessage {
    public Stop(String details) {
      this.details = details;
    }
  }

  public static abstract class OutgoingMessage {
    public String details = null;
    public String toString() {
      return this.getClass().getName() + "(details = " + details + ")";
    }
  }

  public static class Succeeded extends OutgoingMessage {
    public Succeeded(String details) {
      this.details = details;
    }
  }
  public static class Failed extends OutgoingMessage {
    public Failed(String details) {
      this.details = details;
    }
  }
}
