package org.enricogiurin.ocp17.book.ch10;

import java.util.ArrayList;
import java.util.stream.Stream;

/**
 * in this clas we want to use the simple collect() method from stream. not using Collectors
 */

public class StreamCollect {

  public static void main(String[] args) {
    new StreamCollect().evenNumbers();
  }

  void evenNumbers() {
    Stream<Integer> numbers = Stream.of(1, 5, 6, 7, 12, 578, 83, 12, 8358, 464, 802, 973, 13);
    ArrayList<Integer> evens = numbers.collect(
        () -> new ArrayList<>(),  //supplier
        (list, n) -> {           //accumulator
          if (n % 2 == 0) {
            list.add(n);
          }
        },
        (listA, resultList) -> resultList.addAll(listA)  //combiner
    );
    //[6, 12, 578, 12, 8358, 464, 802]
    System.out.println(evens);

  }

}
