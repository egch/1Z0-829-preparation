package org.enricogiurin.ocp17.book.ch8.functionalinterface.jdk.primitive;

import java.util.function.DoubleToLongFunction;
import java.util.function.Function;


/**
 * Both IN/OUT are primitives!!!! IN: double (primitive) OUT: long (primitive)
 */
public class UsageOfDoubleToLongFunction {

  public static void main(String[] args) {
    new UsageOfDoubleToLongFunction().methodReference();
  }

  void anonymous() {
    DoubleToLongFunction doubleToLongFunction = new DoubleToLongFunction() {
      @Override
      public long applyAsLong(double value) {
        return (long) value;
      }
    };
    long value = doubleToLongFunction.applyAsLong(5.5D);
    System.out.println(value); //5
  }

  void lambda() {
    DoubleToLongFunction lambda = (double d) -> Math.round(d);
    long l = lambda.applyAsLong(5.7);
    System.out.println(l); //6
  }

  void wrong_lambda() {
    //Incompatible parameter types in lambda expression: expected double but found Double
    //DoubleToLongFunction lambda = (Double d) -> Math.round(d);

    //This lambda can be define as a Function<Double, Long>
    Function<Double, Long> doubleLongFunction = (Double d) -> Math.round(d);

  }

  void methodReference() {
    DoubleToLongFunction mr = Math::round;
    long l = mr.applyAsLong(5.2);
    System.out.println(l); //5
  }

}
