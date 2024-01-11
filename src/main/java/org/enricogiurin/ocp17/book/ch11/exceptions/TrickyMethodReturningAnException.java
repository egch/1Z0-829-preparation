package org.enricogiurin.ocp17.book.ch11.exceptions;

public class TrickyMethodReturningAnException {

  public static void main(String[] args) {
    //Exception in thread "main" java.lang.RuntimeException
    new TrickyMethodReturningAnException().check(new RuntimeException());
  }

  /**
   * This method compiles.
   * It throws the exception, and it does not return any, legal.
   * @param e
   * @return
   */
   RuntimeException check(RuntimeException e){
     throw e;
   }

}
