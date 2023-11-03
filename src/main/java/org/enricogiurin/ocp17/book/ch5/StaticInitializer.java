package org.enricogiurin.ocp17.book.ch5;

public class StaticInitializer {

  private static final int two;
  private static final int three = 3;
  private static int one;

  static {
    one = 1;
    two = 2;
    //not allowed three is already initialized
    //three = 3;

  }

  //does not compile as four is not initialized neither here nor in the static block
  //private static final int four;

}
