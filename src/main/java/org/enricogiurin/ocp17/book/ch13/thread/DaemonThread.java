package org.enricogiurin.ocp17.book.ch13.thread;

public class DaemonThread {

  Runnable endLessThread = () -> {
    while (2 < 5) {
      System.out.println("thread is alive...");
      try {
        Thread.sleep(1000);

      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  };

  public static void main(String[] args) {
    new DaemonThread().notDaemonThread();
  }

  /**
   * The started thread will run forever as it's not a daemon thread.
   */
  void daemonThread() {
    Thread thread = new Thread(endLessThread);
    boolean daemon = thread.isDaemon();
    System.out.println("daemon: " + daemon);
    thread.start();
    System.out.println("end of the main");
    //output
    //daemon: false
    //end of the main
    //thread is alive...
    //thread is alive...
    //....and goes on
  }

  void notDaemonThread() {
    Thread thread = new Thread(endLessThread);
    thread.setDaemon(true);
    boolean daemon = thread.isDaemon();
    System.out.println("daemon: " + daemon);
    thread.start();
    System.out.println("end of the main");
    //output (possible)
    //daemon: true
    //end of the main
    //thread is alive...
    //and jms exit

  }

}
