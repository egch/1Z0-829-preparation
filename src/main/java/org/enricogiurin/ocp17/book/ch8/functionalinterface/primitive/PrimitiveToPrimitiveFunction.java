package org.enricogiurin.ocp17.book.ch8.functionalinterface.primitive;

import java.util.function.IntToDoubleFunction;
import java.util.function.IntToLongFunction;

public class PrimitiveToPrimitiveFunction {

  public static void main(String[] args) {
    new PrimitiveToPrimitiveFunction().intToLongFunction();
  }
  void intToDoubleFunction() {
    IntToDoubleFunction intToDoubleFunction = (int n) -> (double)n/10;
    double v = intToDoubleFunction.applyAsDouble(4);
    System.out.println(v);
  }

  void intToLongFunction(){
    IntToLongFunction intToLongFunction = (int n)->Long.MAX_VALUE;
    long result = intToLongFunction.applyAsLong(5);
    System.out.println(result);
  }

}
