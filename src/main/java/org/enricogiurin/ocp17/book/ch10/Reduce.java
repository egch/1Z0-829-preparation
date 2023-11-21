package org.enricogiurin.ocp17.book.ch10;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.BinaryOperator;
import java.util.stream.Stream;

public class Reduce {

  public static void main(String[] args) {
    new Reduce().reduceThreeArgumentsWithUDifferentThanT();
  }

  void reduceOneArg() {
    BinaryOperator<String> binaryOperator = (s1, s2) -> s1 + ", " + s2;
    //stream with multiple elements
    Stream<String> stream = Stream.of("1", "2", "3", "4", "5");
    //it there is one sing arg the result is an optional
    Optional<String> result = stream.reduce(binaryOperator);
    //1, 2, 3, 4, 5
    result.ifPresent(System.out::println);
    //stream with single element
    stream = Stream.of("1");
    Optional<String> result2 = stream.reduce(binaryOperator);
    //1
    result2.ifPresent(System.out::println);
    //empty stream
    stream = Stream.empty();
    Optional<String> result3 = stream.reduce(binaryOperator);
    //empty string
    result3.ifPresent(System.out::println);
  }

  void reduceTwoArguments() {
    BinaryOperator<String> binaryOperator = (s1, s2) -> s1 + ", " + s2;

    Stream<String> stream = Stream.of("1", "2", "3", "4", "5");
    String result = stream.reduce("", binaryOperator);
    System.out.println(result);
  }

  void reduceThreeArguments() {
    Stream<Integer> numbers = Stream.of(1, 2, 3, 4, 5);

    // Identity: 1 (initial value), Accumulator: (a, b) -> a * b (multiply two integers)
    // Combiner: (p1, p2) -> p1 * p2 (combine partial products)
    int product = numbers.reduce(1, (a, b) -> a * b, (p1, p2) -> p1 * p2);

    System.out.println("Product of elements: " + product);
  }

  //created by CGPT
  void reduceThreeArgumentsWithUDifferentThanT() {
    //we convert a list of numbers into a string
    List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);

    // Using reduction with three arguments to concatenate integers to a String
    String concatenatedString = numbers.stream()
        .reduce(
            "Numbers: ",                        // Identity value (base string)
            (String s, Integer n) -> s + n,
            // Accumulator function:I have enlightened the real type String and Integer
            (st1, st2) -> st1 + st2    // Combiner function (combine results of parallel execution)
        );
    System.out.println(concatenatedString); //Numbers: 12345
  }
}
