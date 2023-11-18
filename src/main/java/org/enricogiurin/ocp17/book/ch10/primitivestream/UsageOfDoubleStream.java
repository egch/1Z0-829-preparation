package org.enricogiurin.ocp17.book.ch10.primitivestream;

import java.util.OptionalDouble;
import java.util.stream.DoubleStream;

public class UsageOfDoubleStream {

  public static void main(String[] args) {
    new UsageOfDoubleStream().methods();
  }
  void generateRandom() {
    DoubleStream.generate(Math::random)
        .limit(5L)
        .forEach(System.out::println);
  }

  void fractions() {
    DoubleStream.iterate(1D/2, d->d/2)
        .limit(5L)
        .forEach(System.out::println);
    //0.5
    //0.25
    //0.125
    //0.0625
    //0.03125
  }

  void methods() {

    //here we have an OptionalDouble as the stream could be empty
    OptionalDouble max = DoubleStream.generate(Math::random)
        .limit(5L)
        .max();
    max.ifPresent(n-> System.out.println("max is: "+n));

    OptionalDouble min = DoubleStream.generate(Math::random)
        .limit(5L)
        .min();
    min.ifPresent(n-> System.out.println("min is: "+n));

    //here we have an OptionalDouble as the stream could be empty
    OptionalDouble average = DoubleStream.generate(Math::random)
        .limit(5L)
        .average();
    average.ifPresent(n-> System.out.println("average is: "+n));

    /*
      from here no Optional
     */

    //here we have a double because in case of empty stream ths sum is 0.0
    double sum = DoubleStream.generate(Math::random)
        .limit(5L)
        .sum();
    System.out.println("sum is: "+ sum);

    //here we have a long because in case of empty stream the count is zero
    long count = DoubleStream.generate(Math::random)
        .limit(5L)
        .count();
    System.out.println("count is: "+ count);


  }

}
