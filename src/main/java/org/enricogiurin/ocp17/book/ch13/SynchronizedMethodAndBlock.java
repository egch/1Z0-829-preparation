package org.enricogiurin.ocp17.book.ch13;

public class SynchronizedMethodAndBlock {

  private static String message() {
    return "hello";
  }

  //hello() and ciao() they are equivalent
  void hello() {
    synchronized (this) {
      System.out.println("Hello");
    }
  }

  synchronized void ciao() {
    System.out.println("ciao");
  }

  String synchronizedOnClass() {
    //this is a synchronized block on the class
    synchronized (SynchronizedMethodAndBlock.class) {
      return message();
    }
  }
}
