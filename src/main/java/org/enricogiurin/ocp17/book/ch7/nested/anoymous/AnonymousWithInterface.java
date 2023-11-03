package org.enricogiurin.ocp17.book.ch7.nested.anoymous;

public class AnonymousWithInterface {

  public static void main(String[] args) {
    new AnonymousWithInterface().startThread();
  }

  void startThread() {
    Runnable runnable = new Runnable() {
      @Override
      public void run() {
        System.out.println("thread is running");
      }
    };
    new Thread(runnable).start();
    System.out.println("end");
  }

}
