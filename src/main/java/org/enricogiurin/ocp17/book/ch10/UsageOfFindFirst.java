package org.enricogiurin.ocp17.book.ch10;

import java.util.OptionalInt;
import java.util.stream.IntStream;

public class UsageOfFindFirst {

  public static void main(String[] args) {
    new UsageOfFindFirst().parallel();
  }
  //it always prints 1
  void serial() {
    IntStream.range(1, 100)
        .boxed()
        .findFirst()
        .ifPresent(n -> System.out.println(n));
  }

  void serialNoBoxed() {
    //note that it's an OptionalInt
    OptionalInt first = IntStream.range(1, 100)
        .findFirst();
    if (first.isPresent()) {
      //note that getAsInt
      int asInt = first.getAsInt();
      System.out.println(asInt);
    }
  }

  //does it always print 1?
  void parallel() {
    IntStream.range(1, 100)
        .boxed()
        .parallel()
        .findFirst()
        .ifPresent(System.out::println);
  }

}
