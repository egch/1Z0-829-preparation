package org.enricogiurin.ocp17.ch6;

public class PrivateFinalMethods {

  // marking a method as private final is redundant and unnecessary.
  //as private method cannot be necessary
  private final void sayHello() {
    System.out.println("hello");
  }
}
