package org.enricogiurin.ocp17.ch13;

import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.IntStream;

public class UseOfAtomicWrapper {

  public static void main(String[] args) {
    new UseOfAtomicWrapper().undeterminedResult();
  }

  //one of possible result
  //100 91
  void undeterminedResult() {
    var value1 = new AtomicLong(0);
    final long[] value2 = {0};
    IntStream.iterate(1, i -> 1).limit(100).parallel()
        .forEach(i -> value1.incrementAndGet());
    IntStream.iterate(1, i -> 1).limit(100).parallel()
        .forEach(i -> ++value2[0]);

    //the first will be always 100 as it uses AtomicLong
    //the second is undetermined
    System.out.println(value1 + " " + value2[0]);
  }
}
