package org.enricogiurin.ocp17.book.ch13.scheduledexecutorservice;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;


/**
 * Javadoc: If any execution of this task takes longer than its period, then subsequent executions
 * may start late, but will not concurrently execute.
 *
 * @see ScheduledExecutorService#scheduleAtFixedRate(Runnable, long, long, TimeUnit)
 */
public class ScheduleAtFixedRate {

  private final AtomicInteger counter = new AtomicInteger(0);
  Runnable runnable = () -> {
    long threadId = counter.getAndIncrement();
    System.out.println("Started thread %d".formatted(threadId));
    try {
      Thread.sleep(2_000);
      System.out.println("completed thread %d".formatted(threadId));
    } catch (Exception e) {
      e.printStackTrace();
    }
  };

  public static void main(String[] args) {
    new ScheduleAtFixedRate().scheduleAtFixRate();
  }

  //the threads do not overlap!
  //[javadoc]: If any execution of this task takes longer than its period, then subsequent executions may start late, but will not concurrently execute.

  //possible output:

  //Started thread 0
  //completed thread 0
  //Started thread 1
  //completed thread 1
  //Started thread 2
  //completed thread 2
  void scheduleAtFixRate() {
    ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(100);
    try {
      scheduledExecutorService.scheduleAtFixedRate(runnable, 5, 100, TimeUnit.MILLISECONDS);
      try {
        Thread.sleep(20_000);
      } catch (InterruptedException e) {
        throw new RuntimeException(e);
      }
    } finally {
      scheduledExecutorService.shutdown();
    }
  }

}
