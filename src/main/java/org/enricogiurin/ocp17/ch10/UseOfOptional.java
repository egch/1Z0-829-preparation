package org.enricogiurin.ocp17.ch10;

import java.util.Optional;

public class UseOfOptional {

  public static void main(String[] args) {
    new UseOfOptional().use();
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
}
