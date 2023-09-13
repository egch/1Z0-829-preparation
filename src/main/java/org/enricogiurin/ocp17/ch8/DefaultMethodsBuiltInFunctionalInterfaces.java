package org.enricogiurin.ocp17.ch8;

import java.util.function.Function;
import java.util.function.Predicate;

public class DefaultMethodsBuiltInFunctionalInterfaces {

  public static void main(String[] args) {
    new DefaultMethodsBuiltInFunctionalInterfaces().functionCompose();
  }

  void predicate() {
    Predicate<String> isLC = s -> s.equals(s.toLowerCase());
    Predicate<String> startWithB = s -> s.startsWith("b");

    Predicate<String> isLCAndStartWithB = isLC.and(startWithB);
    System.out.println(isLCAndStartWithB.test("banana")); //true

    Predicate<String> isLcOrStartWithB = isLC.or(startWithB);
    System.out.println(isLcOrStartWithB.test("banAna")); //true

    Predicate<String> isLCAndNotStartWithB = isLC.and(startWithB.negate());
    System.out.println(isLCAndNotStartWithB.test("banana")); //false
  }

  void functionAndThen() {
    // Define a Function to parse a String to an Integer
    Function<String, Integer> parseFunction = Integer::parseInt;

    // Define a Function to double the Integer
    Function<Integer, Integer> doubleFunction = x -> x * 2;

    Function<String, Integer> result = parseFunction.andThen(doubleFunction);
    System.out.println(result.apply("23"));  //46
  }

  void functionCompose() {
    Function<Integer, Integer> after = a -> a + 4;
    Function<Integer, Integer> before = a -> a * 3;
    Function<Integer, Integer> compose = after.compose(before);
    System.out.print(compose.apply(2));  // (2*3) + 4 = 10
  }

}
