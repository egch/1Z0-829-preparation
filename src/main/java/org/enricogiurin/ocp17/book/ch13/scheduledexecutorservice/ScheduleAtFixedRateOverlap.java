package org.enricogiurin.ocp17.book.ch13.scheduledexecutorservice;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 *   From Oracle javadoc: https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/util/concurrent/ScheduledThreadPoolExecutor.html
 *   If any execution of this task takes longer than its period, then subsequent executions may start late,
 *   but will not concurrently execute.
 *   Successive executions of a task scheduled via scheduleAtFixedRate or scheduleWithFixedDelay do not overlap.
 *   While different executions may be performed by different threads, the effects of prior executions happen-before those of subsequent ones.
 */
public class ScheduleAtFixedRateOverlap {

  public static void main(String[] args) {
    new ScheduleAtFixedRateOverlap().scheduleAtFixRate();
  }

  void scheduleAtFixRate() {
    ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(100);
    try {
      Runnable runnable = new BasicThread();
      scheduledExecutorService.scheduleAtFixedRate(runnable, 1, 20, TimeUnit.MILLISECONDS);
      try {
        Thread.sleep(30 * 1_000);
      } catch (InterruptedException e) {
        throw new RuntimeException(e);
      }
    }finally {
     scheduledExecutorService.shutdown();
    }
  }
  //possible output - the threads do not overlap!!!
  //started thread 0
  //completed thread 0
  //started thread 1
  //completed thread 1
  class BasicThread implements Runnable {
    private AtomicInteger index = new AtomicInteger(0);
    static final int SLEEP_TIME = 2_000;

    @Override
    public void run() {
      final int value = index.getAndIncrement();
      System.out.println("started thread %s".formatted(value));
      try {
        Thread.sleep(SLEEP_TIME);
        System.out.println("completed thread %s".formatted(value));
      }catch (InterruptedException e) {
        throw new RuntimeException(e);
      }
    }
  }

}
