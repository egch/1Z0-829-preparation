package org.enricogiurin.ocp17.book.ch8.lambda;

import java.util.Comparator;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;

public class UseOfVarInLambda {

  public void method() {
    x((var x) -> {
    }, (var x, var y) -> false);
  }

  void lambdaComparatorWIthVar() {
    Comparator<String> c1 = (var s1, var s2) -> 0;
    //Cannot mix 'var' and explicitly typed parameters in lambda expression
    //Comparator<String> c2NotValid = (var s1, String s2) -> 0;

    //I cannot variable with type and without
   // Comparator<String> c3  = (String s, t) -> 0;
  }

  public void x(Consumer<String> x, BinaryOperator<Boolean> y) {
  }
}
