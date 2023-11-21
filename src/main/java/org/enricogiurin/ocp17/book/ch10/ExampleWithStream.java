package org.enricogiurin.ocp17.book.ch10;

import java.util.stream.IntStream;

public class ExampleWithStream {

  public static void main(String[] args) {
    new ExampleWithStream().unordered();
  }

  void unordered() {
    IntStream.rangeClosed(1, 10)
        .boxed()
        .unordered()
        .parallel()
        .forEach(n -> System.out.print(n + " "));
  }

}
