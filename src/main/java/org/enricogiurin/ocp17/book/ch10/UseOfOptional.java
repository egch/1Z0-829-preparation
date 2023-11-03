package org.enricogiurin.ocp17.book.ch10;

import java.util.Optional;

public class UseOfOptional {

  public static void main(String[] args) {
    new UseOfOptional().optionalThrowWithSupplier();
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
    optional.orElseThrow(()->new RuntimeException("no value!"));
  }
}
