package org.enricogiurin.ocp17.book.ch10.primitivestream;

import java.util.stream.DoubleStream;

public class UsageOfDoubleStream {

  public static void main(String[] args) {
    new UsageOfDoubleStream().fractions();
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

}
