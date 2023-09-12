package org.enricogiurin.ocp17.ch8;

import java.time.LocalDateTime;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

public class BuiltInFunctionalInterfaces {

  public static void main(String[] args) {
    new BuiltInFunctionalInterfaces().unaryOperator();
  }
  void supplier() {
    Supplier<LocalDateTime> supplier = LocalDateTime::now;
    System.out.println(supplier.get());
  }

  void consumer() {
    Consumer<LocalDateTime> consumerLambda = ldt -> System.out.println(ldt);
    Consumer<LocalDateTime> consumerMR = System.out::println;
    consumerLambda.accept(LocalDateTime.now());
    consumerMR.accept(LocalDateTime.now());
  }

  void function() {
    Function<Double, String> functionLambda = d->String.valueOf(d);
    Function<Double, String> functionMR = String::valueOf;
    System.out.println(functionLambda.apply(5.4D));
    System.out.println(functionMR.apply(0.4D));
  }

  void predicate() {
    Predicate<String> predicateLambda = s -> s.isEmpty();
    Predicate<String> predicateMR = String::isEmpty;
    System.out.println(predicateLambda.test("aa"));
    System.out.println(predicateMR.test(""));
  }

  void unaryOperator() {
    UnaryOperator<String> unaryOperatorLambda = s->s.toUpperCase();
    UnaryOperator<String> unaryOperatorMR = String::toUpperCase;
    System.out.println(unaryOperatorLambda.apply("aaaa"));
    System.out.println(unaryOperatorMR.apply("aaaa"));
  }

}
