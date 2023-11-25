package org.enricogiurin.ocp17.book.ch10;

import java.util.stream.Stream;

public class FindAnyFirst {

  public static void main(String[] args) {
    new FindAnyFirst().findFirst();
  }

  void findAny() {
    //infinite stream
    Stream.iterate(1, n -> n + 1)
        .findAny()
        .ifPresent(System.out::println);  //1
  }

  void findFirst() {
    Stream.of("a", "b", "c")
        .findFirst()
        .ifPresent(System.out::println); //a
  }
}
