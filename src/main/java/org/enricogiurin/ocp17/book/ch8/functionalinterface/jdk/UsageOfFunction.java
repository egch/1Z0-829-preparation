package org.enricogiurin.ocp17.book.ch8.functionalinterface.jdk;

import java.util.function.Function;

public class UsageOfFunction {

  public static void main(String[] args) {
    new UsageOfFunction().compose();
  }

  void compose() {
    Function<Integer, Integer> after = n -> n * 2;
    Function<Integer, Integer> before = n -> n + 3;
    Function<Integer, Integer> compose = after.compose(before);

    //Returns a composed function that first applies the before function to its input, and then applies this function to the result.
    Integer result = compose.apply(4);  //(4+3) * 2
    System.out.println(result);  //14
  }


  //CGPT
  void andThen() {
    Function<String, String> toUpperCase = String::toUpperCase;

    // Define the second function: Add a prefix
    Function<String, String> addPrefix = s -> "Mr. " + s;

    // Compose the functions using andThen
    Function<String, String> composedFunction = addPrefix.andThen(toUpperCase);

    // Apply the composed function
    String result = composedFunction.apply("hello");

    // Output the result
    System.out.println(result);  // Output: MR. HELLO
  }
}
