package org.enricogiurin.ocp17.book.ch13;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

public class UseOfLinkedBlockingQueue {

  public static void main(String[] args) {
    new UseOfLinkedBlockingQueue().usage();
  }

  void usage() {
    LinkedBlockingQueue<Integer> queue = new LinkedBlockingQueue<>(5);
    producer(queue);
    consumer(queue);
  }

  void producer(LinkedBlockingQueue<Integer> blockingQueue) {
    ExecutorService executorService = Executors.newCachedThreadPool();
    try {
      for (int j = 0; j < 10; j++) {
        final int value = j;
        executorService.execute(() -> {
          try {
            blockingQueue.offer(value, 10, TimeUnit.SECONDS);
          } catch (InterruptedException e) {
            throw new RuntimeException(e);
          }
        });
      }
    } finally {
      executorService.shutdown();
    }
  }

  void consumer(LinkedBlockingQueue<Integer> blockingQueue) {
    Runnable read = () -> {
      Integer value;
      try {
        value = blockingQueue.poll(10, TimeUnit.SECONDS);
        Thread.sleep(1000);
      } catch (InterruptedException e) {
        throw new RuntimeException(e);
      }
      System.out.println("consumed from queue: " + value);
    };

    ExecutorService executorService = Executors.newSingleThreadExecutor();
    try {
      for (int j = 0; j < 10; j++) {
        executorService.execute(read);
      }
    } finally {
      executorService.shutdown();
    }

  }

}
