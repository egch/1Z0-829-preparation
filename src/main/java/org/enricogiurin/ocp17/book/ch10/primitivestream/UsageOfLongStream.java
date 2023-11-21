package org.enricogiurin.ocp17.book.ch10.primitivestream;

import java.util.OptionalDouble;
import java.util.stream.LongStream;

public class UsageOfLongStream {

  public static void main(String[] args) {
    new UsageOfLongStream().average();
  }

  void sum() {
    LongStream range = LongStream.range(1, 20);
    long sum = range.sum();
    System.out.println("sum is: " + sum);
  }

  void average() {
    LongStream rangeClosed = LongStream.rangeClosed(1, 20);
    //note that is an OptionalDouble
    OptionalDouble optionalDouble = rangeClosed.average();
    if (optionalDouble.isPresent()) {
      System.out.println("average is: " + optionalDouble.getAsDouble()); //average is: 10.5
    }

    LongStream emptyStream = LongStream.empty();
    optionalDouble = emptyStream.average();
    if (optionalDouble.isPresent()) {
      System.out.println("average is: " + optionalDouble.getAsDouble());
    } else {
      System.out.println("no data found");
    }

  }

}
