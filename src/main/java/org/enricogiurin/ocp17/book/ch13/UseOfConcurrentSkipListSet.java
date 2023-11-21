package org.enricogiurin.ocp17.book.ch13;

import java.util.concurrent.ConcurrentSkipListSet;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class UseOfConcurrentSkipListSet {

  private final ConcurrentSkipListSet<Integer> concurrentSet =
      new ConcurrentSkipListSet<>();

  public static void main(String[] args) throws InterruptedException {
    new UseOfConcurrentSkipListSet().runExample();
  }

  private void runExample() throws InterruptedException {
    // Create an ExecutorService with a fixed pool of threads
    ExecutorService executorService = Executors.newFixedThreadPool(3);

    // Submit tasks to add elements concurrently
    try {
      executorService.submit(() -> addElements(1, 10));
      executorService.submit(() -> addElements(6, 10));
    } finally {
      executorService.shutdown();
    }

    executorService.awaitTermination(1, TimeUnit.MINUTES);
    if (executorService.isTerminated()) {
      System.out.println("all tasks completed");
    }
    iterateOverSet();

  }

  private void addElements(int start, int end) {
    for (int i = start; i <= end; i++) {
      concurrentSet.add(i);
      System.out.println(Thread.currentThread().getName() + " added: " + i);
    }
  }

  private void iterateOverSet() {
    for (Integer element : concurrentSet) {
      System.out.println(element);
    }
  }

}
