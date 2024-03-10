package org.enricogiurin.ocp17.book.ch11.exceptions;

public class ExceptionIsFinalInCatchBlock {

  void finalException() {
    try {
      int a = 5 / 0;
    } catch (ArithmeticException | ClassCastException e) {
      //The exception parameter in a multi-catch clause is implicitly final.
      //e =  new RuntimeException();  //DOES NOT COMPILE
    }
  }

}
