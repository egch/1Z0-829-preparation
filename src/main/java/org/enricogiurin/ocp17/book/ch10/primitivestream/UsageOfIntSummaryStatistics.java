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
    System.out.println("min: %s - max: %s - avg: %s"
        .formatted(min, max, avg));

  }

}
