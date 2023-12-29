package org.enricogiurin.ocp17.book.ch10;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class FindAnyFirst {

  public static void main(String[] args) {
    new FindAnyFirst().sorted();
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

  void sorted() {
    List<Integer> list = List.of(1, 3, 1);
    Optional<Integer> optional = list.stream()
        .sorted()  //if comparator is missing, it sorts based on natural order
        .findFirst();  //keep in mind that findFirst() returns an Optional
    optional.ifPresent(System.out::println);  //1

    list.stream()
        .sorted()
        .findAny()  //it is highly likely that the code will find 1 but not guaranteed
        .ifPresent(System.out::println);  //1 (likely)
  }
}
