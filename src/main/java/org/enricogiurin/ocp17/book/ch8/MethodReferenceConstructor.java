package org.enricogiurin.ocp17.book.ch8;

import java.util.function.Function;

public class MethodReferenceConstructor {

  public static void main(String[] args) {
    new MethodReferenceConstructor().createNewString();
  }

  void createNewString() {
    Function<String, String> mr = String::new;
    String hello = mr.apply("Hello");
    System.out.println(hello);
  }


}
