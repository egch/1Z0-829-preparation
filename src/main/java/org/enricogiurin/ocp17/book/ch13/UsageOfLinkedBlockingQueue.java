package org.enricogiurin.ocp17.book.ch13;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

public class UsageOfLinkedBlockingQueue {

  public static void main(String[] args) {
    new UsageOfLinkedBlockingQueue().usage();
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
            //we might end up a bit before inserting the 6th element
            //since the blocking queue has capacity of 5
            blockingQueue.offer(value, 10, TimeUnit.SECONDS);
            System.out.println("Inserted %d to the queue".formatted(value));
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
        Thread.sleep(10);
      } catch (InterruptedException e) {
        throw new RuntimeException(e);
      }
      System.out.println("consumed from queue: " + value);
    };

    //we wait a second before starting to process
    try {
      Thread.sleep(1000);
    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    }
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
//This could be a possible output
    /*
    Inserted 2 to the queue
    Inserted 0 to the queue
    Inserted 3 to the queue
    Inserted 1 to the queue
    Inserted 4 to the queue
    Inserted 5 to the queue
    consumed from queue: 0
    Inserted 6 to the queue
    consumed from queue: 1
    Inserted 7 to the queue
    consumed from queue: 2
    Inserted 8 to the queue
    consumed from queue: 3
    Inserted 9 to the queue
    consumed from queue: 4
    consumed from queue: 5
    consumed from queue: 6
    consumed from queue: 7
    consumed from queue: 8
    consumed from queue: 9
    */
