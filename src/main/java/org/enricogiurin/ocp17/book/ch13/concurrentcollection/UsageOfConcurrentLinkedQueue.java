package org.enricogiurin.ocp17.book.ch13.concurrentcollection;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class UsageOfConcurrentLinkedQueue {

  static final int NUM_ELEMENTS = 100;
  private Queue<Integer> queue = new ConcurrentLinkedQueue<>();

  public static void main(String[] args) throws InterruptedException {
    new UsageOfConcurrentLinkedQueue().addAndConsume();
  }

  void addAndConsume() throws InterruptedException {
    ExecutorService executorService = Executors.newCachedThreadPool();
    for (int j = 0; j < NUM_ELEMENTS; j++) {
      final int num = j;
      executorService.submit(() -> {
        try {
          Thread.sleep(5);
        } catch (InterruptedException e) {
          throw new RuntimeException(e);
        }
        queue.offer(num);
      });
    }
    for (int j = 0; j < NUM_ELEMENTS; j++) {
      executorService.submit(() -> {
        Integer poll = queue.poll();
        System.out.println("consumed " + poll);
      });
    }
    executorService.shutdown();
    boolean awaitTermination = executorService.awaitTermination(2, TimeUnit.SECONDS);
    if (awaitTermination) {
      System.out.println("size queue is: " + queue.size());
    }
  }

}
