package org.enricogiurin.ocp17.book.ch13.parallelstream;

import java.util.stream.IntStream;

public class ParallelStreamWorker {

  public static void main(String[] args) {
    //number of processors: 12
    getProcessorCount();
    new ParallelStreamWorker().findAny();
  }

  private static void getProcessorCount() {
    var numProcessors = Runtime.getRuntime().availableProcessors();
    System.out.println("number of processors: " + numProcessors);

  }

  int doWork(int value) {
    try {
      Thread.sleep(1000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    return value;
  }

  void sequentialWorkers() {
    long start = System.currentTimeMillis();
    IntStream.rangeClosed(1, 12)
        .map(this::doWork)
        .forEach(n -> System.out.print(n + " "));
    long end = System.currentTimeMillis();
    //time taken: 12039ms
    System.out.println("time taken: " + (end - start) + "ms");
  }

  void parallelWorkers() {
    long start = System.currentTimeMillis();
    IntStream.rangeClosed(1, 12)
        .parallel()
        .map(this::doWork)
        .forEach(n -> System.out.print(n + " "));
    //random order: 8 4 9 2 7 11 1 6 3 12 10 5
    long end = System.currentTimeMillis();
    //time taken: 1015ms
    System.out.println("time taken: " + (end - start) + "ms");
  }

  void parallelWorkersSorted() {
    long start = System.currentTimeMillis();
    IntStream.rangeClosed(1, 12)
        .parallel()
        .map(this::doWork)
        .forEachOrdered(n -> System.out.print(n + " "));
    //1 2 3 4 5 6 7 8 9 10 11 12 - order guaranteed
    long end = System.currentTimeMillis();
    //time taken: 1015ms
    System.out.println("time taken: " + (end - start) + "ms");
  }

  void findAny() {
    IntStream.rangeClosed(1, 12)
        .parallel()
        .map(this::doWork)
        .findAny()
        .ifPresent(System.out::println);  //can be any...1, 111

  }

}
