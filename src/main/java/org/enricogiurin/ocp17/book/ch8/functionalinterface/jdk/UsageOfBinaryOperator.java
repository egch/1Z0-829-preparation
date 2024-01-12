package org.enricogiurin.ocp17.book.ch8.functionalinterface.jdk;

import java.util.function.BinaryOperator;

public class UsageOfBinaryOperator {

  public static void main(String[] args) {
    new UsageOfBinaryOperator().mr();
  }

  void binaryOperator() {
    BinaryOperator<String> binaryOperator = (s1, s2) -> s1 + ", " + s2;
    String result = binaryOperator.apply("Hello", "World");
    System.out.println(result);
  }

  void mr() {
    BinaryOperator<String> binaryOperator = String::concat;
    String result = binaryOperator.apply("Hi, ", "there");
    System.out.println(result);
  }

}
