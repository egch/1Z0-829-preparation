package org.enricogiurin.ocp17.book.ch11.trywithresources;

public class ExceptionInAutoCloseable {

  //here I use the throws clause in the method signature
  void tryWith() throws Exception {
    try (var myAutoCloseable = new MyAutoCloseable()) {
      System.out.println("hello");
    }
  }

  //here I catch the exception
  void tryWithCatch() {
    try (var myAutoCloseable = new MyAutoCloseable()) {
      System.out.println("hello");
    } catch (Exception e) {

    }
  }


  static class MyAutoCloseable implements AutoCloseable {

    @Override
    public void close() throws Exception {
      System.out.println("closing");
    }
  }
}

