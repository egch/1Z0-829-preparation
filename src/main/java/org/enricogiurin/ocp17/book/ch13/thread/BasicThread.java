package org.enricogiurin.ocp17.book.ch13.thread;

public class BasicThread {

  public static void main(String[] args) {
    new BasicThread().rightStartOfThread();
  }

  void wrongStartOfThread() {
    Thread t = new Thread(() -> System.out.println("hello"));
    //I should have called t.start()
    t.run(); //hello (but within the main thread)
    System.out.println("completed");
  }

  void rightStartOfThread() {
    Thread t = new Thread(() -> System.out.println("hello"));
    t.start();
    System.out.println("completed");
  }

}
