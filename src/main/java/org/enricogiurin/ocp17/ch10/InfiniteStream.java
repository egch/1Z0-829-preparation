package org.enricogiurin.ocp17.ch10;

import java.util.stream.Stream;

public class InfiniteStream {

  public static void main(String[] args) {
    new InfiniteStream().infiniteStream();
  }

  void infiniteStream() {
    Stream.generate(() -> "")
        .filter(s -> s.length() > 0)
        .limit(2)   //no matter the limit, we keep waiting to have elements not empty
        .forEach(System.out::print);
  }

}
