package org.enricogiurin.ocp17.book.ch13.cyclicbarrier;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

public class PartialReachOfCyclicBarrier {

  private int completed = 0;

  public static void main(String[] args) throws InterruptedException {
    new PartialReachOfCyclicBarrier().partialReach();
  }

  private void waitTillFinished(CyclicBarrier c) {
    try {
      c.await();
      completed++;
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }

  public void partialReach() throws InterruptedException {
    ExecutorService executorService = Executors.newCachedThreadPool();

    var cb = new CyclicBarrier(5, () -> System.out.println("cyclic barrier reached"));
    IntStream.iterate(1, i -> i + 1)
        .limit(12)
        .forEach(i -> executorService.submit(() -> waitTillFinished(cb)));
    executorService.shutdown();
    executorService.awaitTermination(2, TimeUnit.SECONDS);
    //we started 12 threads and the CB is 5, that means only 10 completes
    System.out.println("completed: " + completed); //10
    //here the system is still hanging so we need to shut it down
    if (!executorService.isTerminated()) {
      int numberWaiting = cb.getNumberWaiting();
      System.out.println("number waiting: " + numberWaiting);  //number waiting: 2
      System.out.println("shut down all");
      executorService.shutdownNow();
    }
  }

}
