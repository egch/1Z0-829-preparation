package org.enricogiurin.ocp17.book.ch10.primitivestream;

import java.util.OptionalDouble;
import java.util.function.LongToIntFunction;
import java.util.stream.IntStream;
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

  void map() {
    LongToIntFunction longToIntFunction = (long l) -> (int) l;
    LongStream.rangeClosed(1L, 10L)
        .mapToInt(longToIntFunction)  //at this point it's an IntStream
        .forEach(System.out::println);
  }

  void mixedWithIntStream() {
    double average = LongStream.of(6L, 10L)
        .summaryStatistics()
        .getAverage();  //here I have not an optional

    double asDouble = IntStream.of(6, 8)
        .mapToLong(i -> i)
        .average()
        .getAsDouble();  //here I have an optional
  }

}
