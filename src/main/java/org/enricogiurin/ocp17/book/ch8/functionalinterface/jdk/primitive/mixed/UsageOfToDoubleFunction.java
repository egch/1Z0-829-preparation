package org.enricogiurin.ocp17.book.ch8.functionalinterface.jdk.primitive.mixed;

import java.util.function.ToDoubleFunction;

public class UsageOfToDoubleFunction {

  public static void main(String[] args) {
    new UsageOfToDoubleFunction().methodReference();
  }
  void lambda() {
    ToDoubleFunction<String> parseDouble = (String s) -> Double.parseDouble(s);
    double result = parseDouble.applyAsDouble("23.25");
    System.out.println(result);  //23.25
  }

  void methodReference() {
    ToDoubleFunction<String> parseDouble = Double::parseDouble;
    double result = parseDouble.applyAsDouble("89.15");
    System.out.println(result);  //89.15
  }

  void anonymous() {
    ToDoubleFunction<String> toDoubleFunction = new ToDoubleFunction<>() {
      @Override
      public double applyAsDouble(String value) {
        return Double.parseDouble(value);
      }
    };
  }

}
