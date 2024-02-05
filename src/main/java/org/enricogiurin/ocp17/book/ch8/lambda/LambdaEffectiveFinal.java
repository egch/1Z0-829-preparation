package org.enricogiurin.ocp17.book.ch8.lambda;

import java.util.function.Consumer;
import java.util.function.Supplier;

/**
 * This class shows the usage of lambda within a method when it's down to access to local variables
 * or instance variables.
 */
public class LambdaEffectiveFinal {

  private int instanceVariable = 0;
  private Consumer<String> consumer = (s -> System.out.println(s.length()));

  public static void main(String[] args) {
    new LambdaEffectiveFinal().sum(10);
  }

  void sum(int parameter) {
    int localVar = 4;
    Supplier<Integer> supplier = () ->
    {
      return parameter + this.instanceVariable + localVar;
    };

    //I cannot change a local variable used within lambda!
    //Variable used in lambda expression should be final or effectively final
    //I can't change the value of a local variable used within lambda
    //localVar = 6; //does not compile!

    //but I am allowed to change an instance variable used within the lambda
    this.instanceVariable = 6;

    //the same goes with parameter
    //Parameters used in lambda expression should be final or effectively final
    //a = 10;  //does not compile!

    Integer result = supplier.get();
    System.out.println(result);
  }


}
