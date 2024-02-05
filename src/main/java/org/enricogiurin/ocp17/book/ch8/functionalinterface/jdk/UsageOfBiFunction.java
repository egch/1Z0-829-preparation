package org.enricogiurin.ocp17.book.ch8.functionalinterface.jdk;

import java.util.function.BiFunction;
import java.util.function.IntBinaryOperator;

public class UsageOfBiFunction {

  public static void main(String[] args) {
    UsageOfBiFunction instance = new UsageOfBiFunction();
    instance.fi();
    instance.mr();
    instance.anonymous();
  }

  void fi() {
    BiFunction<String, String, Double> averageLength = (s1, s2) ->
        ((double) s1.length() + s2.length()) / 2;
    Double average = averageLength.apply("abcd", "123");
    System.out.println(average);  //3.5 (4+3)/2=3.5
  }

  void mr() {
    BiFunction<String, String, String> concat = String::concat;
    String apply = concat.apply("Hello ", "World");
    System.out.println(apply); //Hello World
  }

  void anonymous() {
    BiFunction<Integer, Integer, Long> sum = new BiFunction<>() {
      @Override
      public Long apply(Integer n1, Integer n2) {
        return (long) n1 + n2;
      }
    };
    Long result = sum.apply(Integer.MAX_VALUE, Integer.MAX_VALUE);
    System.out.println(result); //4294967294
  }

  void biFunction() {
    //Cannot mix 'var' and explicitly typed parameters in lambda expression
    //BiFunction<Integer, Integer, Integer> bf = (Integer x, var y)->5;

    BiFunction<Integer, Integer, Integer> bf1 = (var x, var y) -> 5;
    BiFunction<Integer, Integer, Integer> bf2 = (Integer x, Integer y) -> 5;
    IntBinaryOperator intBinaryOperator = (int x, int y) -> 5;
  }

  void biFunctionWithDouble() {
    //this does not compile
    //while an int(primitive) can be assigned to a double, an int cannot be assigned to a Double (wrapper)
    //BiFunction<Integer, Integer, Double> biFunction = (s, p)->s+p;  //does not compile

    BiFunction<Integer, Double, Double> biFunction = (s, p) -> s + p;  //this compiles!
  }

}
