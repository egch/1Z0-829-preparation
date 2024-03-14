package org.enricogiurin.ocp17.book.ch8.functionalinterface.jdk;

import java.util.function.Function;

public class FunctionWithWrapperOfPrimitive {

  public static void main(String[] args) {
    new FunctionWithWrapperOfPrimitive().calculate();
  }

  void calculate() {
    double amount = 200D;
    int interest = 5;
    double gain = compute(amount, x -> x * interest / 100);
    System.out.println("gain: " + gain); //10.0
  }

  private double compute(double amount, Function<Double, Double> function) {
    return function.apply(amount);
  }

}
