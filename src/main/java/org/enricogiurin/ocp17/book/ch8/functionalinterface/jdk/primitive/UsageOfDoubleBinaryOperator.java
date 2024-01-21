package org.enricogiurin.ocp17.book.ch8.functionalinterface.jdk.primitive;

import java.util.function.DoubleBinaryOperator;

public class UsageOfDoubleBinaryOperator {

  public static void main(String[] args) {
    new UsageOfDoubleBinaryOperator().anonymous();
  }

  void fi() {
    DoubleBinaryOperator dbo = (double d1, double d2) -> d1 + d2;
    double result = dbo.applyAsDouble(4, 7.4);
    System.out.println(result); //11.4
  }

  void mr() {
    DoubleBinaryOperator dbo = Double::sum;
    double value = dbo.applyAsDouble(4.5D, 2.1d);
    System.out.println(value);  //6.6
  }

  void anonymous() {
    DoubleBinaryOperator dbo = new DoubleBinaryOperator() {
      public double applyAsDouble(double d1, double d2) {
        return d1 - d2;
      }
    };
    double result = dbo.applyAsDouble(5D, 3.1D);
    System.out.println(result);  //1.9
  }

}
