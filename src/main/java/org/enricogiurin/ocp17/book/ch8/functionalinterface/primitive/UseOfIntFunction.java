package org.enricogiurin.ocp17.book.ch8.functionalinterface.primitive;

import java.util.function.IntFunction;

public class UseOfIntFunction {

  public static void main(String[] args) {
    new UseOfIntFunction().use();
  }
  void use() {
    IntFunction<Double> fi = n -> (double)n/3;
    Double result = fi.apply(10);
    System.out.println(result); //3.3333333333333335
  }

}
