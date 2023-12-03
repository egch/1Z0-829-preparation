package org.enricogiurin.ocp17.book.ch13.thread;

public class InterruptingThread {

  public static void main(String[] args) {
    new InterruptingThread().interrupt();

  }

  void interruptANotStartedThread() {
    var t = new Thread(() -> talk());
    t.run();  //wrong start of a thread
    t.interrupt(); //this method has no effect as the thread has not started
    //Interrupting a thread that is not alive need not have any effect.
    t.interrupt();
    t.interrupt();
  }

  void interrupt() {
    var t = new Thread(() -> talk());
    t.start();
    //java.lang.InterruptedException: sleep interrupted
    t.interrupt();
  }

  private void talk() {
    try {
      Thread.sleep(1_000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }

}
