package org.enricogiurin.ocp17.ch10.primitivestream;

import java.util.DoubleSummaryStatistics;
import java.util.stream.DoubleStream;

public class Statistics {

  public static void main(String[] args) {
    new Statistics().statistic();
  }

  void statistic() {
    DoubleSummaryStatistics summaryStatistics = DoubleStream.iterate(1D, n -> n + n / 2)
        .limit(10L)
        .summaryStatistics();
    double average = summaryStatistics.getAverage();
    double count = summaryStatistics.getCount();
    double sum = summaryStatistics.getSum();
    double min = summaryStatistics.getMin();
    double max = summaryStatistics.getMax();
    System.out.println("average: "+average);
    System.out.println("count: "+count);
    System.out.println("sum: "+sum);
    System.out.println("min: "+min);
    System.out.println("max: "+max);

  }

}
