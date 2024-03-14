package org.enricogiurin.ocp17.book.ch10.primitivestream;

import java.util.IntSummaryStatistics;
import java.util.stream.IntStream;

public class UsageOfIntSummaryStatistics {

  public static void main(String[] args) {
    new UsageOfIntSummaryStatistics().empty();
  }

  void use() {
    IntSummaryStatistics intSummaryStatistics = IntStream.range(1, 100)
        .summaryStatistics();
    int min = intSummaryStatistics.getMin();
    int max = intSummaryStatistics.getMax();
    double avg = intSummaryStatistics.getAverage();
    long count = intSummaryStatistics.getCount();  //not that is a long
    long sum = intSummaryStatistics.getSum();
    System.out.println("count: %d - min: %s - max: %s - avg: %s - sum: %s"
        .formatted(count, min, max, avg, sum));
    //count: 99 - min: 1 - max: 99 - avg: 50.0 - sum: 4950

  }

  void empty() {
    IntSummaryStatistics intSummaryStatistics = IntStream.empty()
        .summaryStatistics();
    int min = intSummaryStatistics.getMin();
    int max = intSummaryStatistics.getMax();
    double avg = intSummaryStatistics.getAverage();
    long count = intSummaryStatistics.getCount();  //not that is a long
    long sum = intSummaryStatistics.getSum();
    System.out.println("count: %d - min: %s - max: %s - avg: %s - sum: %s"
        .formatted(count, min, max, avg, sum));
    //count: 0 - min: 2147483647 - max: -2147483648 - avg: 0.0 - sum: 0
  }

}
