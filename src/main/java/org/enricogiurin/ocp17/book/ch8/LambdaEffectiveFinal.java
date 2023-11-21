package org.enricogiurin.ocp17.book.ch8;

import java.util.function.Supplier;

/**
 * This class shows the usage of lambda within a method when it's down to access to local variables
 * or instance variables.
 */
public class LambdaEffectiveFinal {

  private int instanceVariable = 0;

  public static void main(String[] args) {
    new LambdaEffectiveFinal().sum(10);
  }

  void sum(int a) {
    int localVar = 4;
    Supplier<Integer> supplier = () -> a + this.instanceVariable + localVar;

    //I cannot change a local variable used within lambda!
    //Variable used in lambda expression should be final or effectively final
    // localVar = 6;

    //but I am allowed to change an instance variable used within the lambda
    this.instanceVariable = 6;

    //the same goes with parameter
    //Variable used in lambda expression should be final or effectively final
    //a = 10;

    Integer result = supplier.get();
    System.out.println(result);
  }

}
