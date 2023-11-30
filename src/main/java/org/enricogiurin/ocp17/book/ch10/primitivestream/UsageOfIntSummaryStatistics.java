package org.enricogiurin.ocp17.book.ch10.primitivestream;

import java.util.IntSummaryStatistics;
import java.util.stream.IntStream;

public class UsageOfIntSummaryStatistics {

  public static void main(String[] args) {
    new UsageOfIntSummaryStatistics().use();
  }
  void use() {
    IntSummaryStatistics intSummaryStatistics = IntStream.range(1, 100)
        .summaryStatistics();
    int min = intSummaryStatistics.getMin();
    int max = intSummaryStatistics.getMax();
    double avg = intSummaryStatistics.getAverage();
    long count = intSummaryStatistics.getCount();
    System.out.println("count: %d - min: %s - max: %s - avg: %s"
        .formatted(count, min, max, avg));

  }

}
