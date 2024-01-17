package org.enricogiurin.ocp17.book.ch8.functionalinterface.jdk;

import java.util.function.UnaryOperator;

public class UsageOfUnaryOperator {

  public static void main(String[] args) {
    new UsageOfUnaryOperator().anonymous();
  }

  void lambda() {
    UnaryOperator<String> unaryOperator = s -> "Hello " + s;
    String welcome = unaryOperator.apply("enrico");
    System.out.println(welcome); //Hello enrico
  }

  void methodReference() {
    UnaryOperator<String> unaryOperator = String::toLowerCase;
    String hello = unaryOperator.apply("HELLO");
    System.out.println(hello); //hello
  }

  void anonymous() {
    UnaryOperator<String> unaryOperator = new UnaryOperator<>() {
      @Override
      public String apply(String s) {
        return s.toUpperCase();
      }
    };
    String hello = unaryOperator.apply("hello");
    System.out.println(hello); //HELLO
  }

  void unaryOperatorWithoutGenerics() {
    //If I do not specify the generics the type is Object
    UnaryOperator up = (Object obj) -> obj;
  }

}
