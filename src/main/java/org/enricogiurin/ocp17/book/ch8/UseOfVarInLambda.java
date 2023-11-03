package org.enricogiurin.ocp17.book.ch8;

import java.util.function.BinaryOperator;
import java.util.function.Consumer;

public class UseOfVarInLambda {

  public void method() {
    x((var x) -> {
    }, (var x, var y) -> false);
  }

  public void x(Consumer<String> x, BinaryOperator<Boolean> y) {
  }
}
