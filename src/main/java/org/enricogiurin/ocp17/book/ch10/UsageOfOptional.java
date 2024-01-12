package org.enricogiurin.ocp17.book.ch10;

import java.util.Optional;

public class UsageOfOptional {

  public static void main(String[] args) {
    new UsageOfOptional().optionalOfNull();
  }

  void use() {
    Optional<Integer> optionalInteger = Optional.of(10);
    if (optionalInteger.isPresent()) {
      System.out.println(optionalInteger.get());
    }
    //lambda usage
    optionalInteger.ifPresent(System.out::println);

    Optional<Integer> empty = Optional.empty();

    //.NoSuchElementException: No value present
    Integer value = empty.get();
  }

  void optionalThrow() {
    Optional<String> optional = Optional.empty();

    //Exception in thread "main" java.util.NoSuchElementException: No value present
    optional.orElseThrow();
  }

  void optionalThrowWithSupplier() {
    Optional<String> optional = Optional.empty();

    //Exception in thread "main" java.lang.RuntimeException: no value!
    optional.orElseThrow(() -> new RuntimeException("no value!"));
    //wrong way
    //optional.orElseThrow(() -> throw new RuntimeException("no value!"));  //does not compile!!
  }

  void optionalOfNull() {
    String message = null;
    //this does not throw any exception
    var optOfNullable = Optional.ofNullable(message);

    try {
      //but if I call the get yes.
      //java.util.NoSuchElementException: No value present
      String tmp = optOfNullable.get();
    } catch (Exception e) {
      e.printStackTrace();
    }

    //this throws a NPE at runtime as I pass the null value
    try {
      //java.lang.NullPointerException
      Optional<String> optMessage = Optional.of(message);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
