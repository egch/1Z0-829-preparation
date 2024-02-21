package org.enricogiurin.ocp17.book.ch5.overloading;

/**
 * Java picks the most specific method signature it can find in an overloading situation. Since
 * promotion is considered first, longs is output. If that method were removed, Java would next go
 * to autoboxing, printing Integers.
 * <p>
 * If both message(long long) and message(Integer Integer) are removed then it calls the method
 * message(varargs)
 */
public class MethodMatchingOverloadingWIthVarargs {

  void callMethod() {
    message(1, 2);
  }

  /*
   * list of overloaded methods
   */
  private void message(short num1, short num2) {
    System.out.println("shorts");
  }

  private void message(int... nums) {
    System.out.println("varargs");
  }

  private void message(Integer num1, Integer num2) {
    System.out.println("Integers");
  }

  private void message(long num1, long num2) {
    System.out.println("longs");
  }

}
