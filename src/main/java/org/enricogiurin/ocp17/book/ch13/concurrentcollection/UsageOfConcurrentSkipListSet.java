package org.enricogiurin.ocp17.book.ch13.concurrentcollection;

import java.util.concurrent.ConcurrentSkipListSet;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

public class UsageOfConcurrentSkipListSet {

  public static void main(String[] args) throws InterruptedException {
    new UsageOfConcurrentSkipListSet().customConcurrentSkipListSet();
  }

  void customConcurrentSkipListSet() {
    //using a reverse sorted order comparator
    ConcurrentSkipListSet<Integer> concurrentSet =
        new ConcurrentSkipListSet<>((c1, c2) -> c2 - c1);
    IntStream.rangeClosed(1, 10)
        .boxed()
        .parallel()
        .forEach(concurrentSet::add);
    //10 9 8 7 6 5 4 3 2 1
    iterateOverSet(concurrentSet);

  }

  void runExample() throws InterruptedException {
    ConcurrentSkipListSet<Integer> concurrentSet =
        new ConcurrentSkipListSet<>();
    // Create an ExecutorService with a fixed pool of threads
    ExecutorService executorService = Executors.newFixedThreadPool(3);

    // Submit tasks to add elements concurrently
    try {
      executorService.submit(() -> addElements(1, 10, concurrentSet));
      executorService.submit(() -> addElements(6, 10, concurrentSet));
    } finally {
      executorService.shutdown();
    }

    executorService.awaitTermination(1, TimeUnit.MINUTES);
    if (executorService.isTerminated()) {
      System.out.println("all tasks completed");
    }
    iterateOverSet(concurrentSet);
  }

  private void addElements(int start, int end, ConcurrentSkipListSet<Integer> concurrentSet) {
    IntStream.rangeClosed(start, end)
        .forEach(value -> {
          concurrentSet.add(value);
          System.out.println(Thread.currentThread().getName() + " added: " + value);
        });
  }

  //ConcurrentSkipListSet is sorted, similar to TreeSet
  private void iterateOverSet(ConcurrentSkipListSet<Integer> concurrentSet) {
    for (Integer element : concurrentSet) {
      System.out.print(element + " "); //1 2 3 4 5 6 7 8 9 10
    }
  }
}
