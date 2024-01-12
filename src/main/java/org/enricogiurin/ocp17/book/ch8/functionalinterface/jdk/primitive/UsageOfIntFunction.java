package org.enricogiurin.ocp17.book.ch8.functionalinterface.jdk.primitive;

import java.util.function.IntFunction;

public class UsageOfIntFunction {

  public static void main(String[] args) {
    new UsageOfIntFunction().use();
  }

  void use() {
    IntFunction<Double> fi = n -> (double) n / 3;
    Double result = fi.apply(10);
    System.out.println(result); //3.3333333333333335
  }

  void invalid() {
    //Incompatible parameter types in lambda expression: expected int but found Integer
    //IntFunction<Integer> intF = (Integer n) -> n;  //does not compile!

    //this is valid because it takes an int (primitive) a return an Integer
    // An int can be autoboxed to Integer.
    IntFunction<Integer> intF = (int n) -> n;
  }

  void anonymous() {
    IntFunction<Integer> intFunction = new IntFunction<>() {
      @Override
      public Integer apply(int value) {
        return value;
      }
    };
  }


}
