package org.enricogiurin.ocp17.book.ch8.lambda;

import java.util.Comparator;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class UsageOfVarInLambda {

  public void method() {
    x((var x) -> {
    }, (var x, var y) -> false);
  }

  void lambdaComparatorWIthVar() {
    Comparator<String> c1 = (var s1, var s2) -> 0;
    //Cannot mix 'var' and explicitly typed parameters in lambda expression
    //Comparator<String> c2NotValid = (var s1, String s2) -> 0;

    //I cannot use variable with type and without
    // Comparator<String> c3  = (String s, t) -> 0;
  }

  void predicate() {
    Predicate<String> pred1 = (final String s) -> s.isEmpty();
    //does not compile as we miss the type declaration
    //Predicate<String> pred2 = (final s) -> s.isEmpty();
    Predicate<String> pred3 = (final var s) -> s.isEmpty();
    Predicate<String> pred4 = (String s) -> s.isEmpty();
    Predicate<String> pred5 = (var s) -> s.isEmpty();

  }

  public void x(Consumer<String> x, BinaryOperator<Boolean> y) {
  }
}
