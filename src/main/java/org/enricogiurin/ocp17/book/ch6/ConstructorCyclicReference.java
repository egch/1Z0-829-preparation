package org.enricogiurin.ocp17.book.ch6;

public class ConstructorCyclicReference {

  public ConstructorCyclicReference() {
  }

  public ConstructorCyclicReference(int arg) {
    this(null);
    System.out.println("int constructor");
  }

  public ConstructorCyclicReference(String arg) {
    System.out.println("String constructor");
  }

  //The compiler notices this circular dependency and does not allow the code to compile
  //Recursive constructor invocation
/*
 public ConstructorCyclicReference(String arg) {
    this(4);
    System.out.println("String constructor");
  }
  */

}
