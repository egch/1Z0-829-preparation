package org.enricogiurin.ocp17.book.ch10.primitivestream;

import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;

public class UsageOfDoubleSummaryStatistics {

  public static void main(String[] args) {
    new UsageOfDoubleSummaryStatistics().summarizingDouble();
  }

  void statistic() {
    DoubleSummaryStatistics summaryStatistics = DoubleStream.iterate(1D, n -> n + n / 2)
        .limit(10L)
        .peek(n -> System.out.print(n + " "))
        .summaryStatistics();
    System.out.println();
    double average = summaryStatistics.getAverage();
    double count = summaryStatistics.getCount();
    double sum = summaryStatistics.getSum();
    double min = summaryStatistics.getMin();
    double max = summaryStatistics.getMax();
    System.out.println("average: " + average);
    System.out.println("count: " + count);
    System.out.println("sum: " + sum);
    System.out.println("min: " + min);
    System.out.println("max: " + max);
  }

  void empty() {
    DoubleSummaryStatistics doubleSummaryStatistics = DoubleStream.empty()
        .summaryStatistics();
    System.out.println("average: " + doubleSummaryStatistics.getAverage()); //0.0
    System.out.println("count: " + doubleSummaryStatistics.getCount()); //0
    System.out.println("min: " + doubleSummaryStatistics.getMin()); //Infinity
    System.out.println("max: " + doubleSummaryStatistics.getMax()); //-Infinity
  }

  void summarizingDouble() {
    record Person(String name, int age) {

    }
    List<Person> people = List.of(new Person("John", 30),
        new Person("Mark", 40),
        new Person("Philip", 50));
    DoubleSummaryStatistics doubleSummaryStatistics = people.stream()
        .collect(Collectors.summarizingDouble(p -> p.age()));
    double max = doubleSummaryStatistics.getMax();
    double min = doubleSummaryStatistics.getMin();
    //min: 30.000000 - max: 50.000000
    System.out.println("min: %f - max: %f".formatted(min, max));
  }

}
