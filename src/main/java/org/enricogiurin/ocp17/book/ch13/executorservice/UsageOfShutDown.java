package org.enricogiurin.ocp17.book.ch13.executorservice;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;

public class UsageOfShutDown {

  public static void main(String[] args) throws InterruptedException {
    new UsageOfShutDown().sendAnotherTaskAfterShutdown();
  }

  void execute() throws InterruptedException {
    ExecutorService executorService = Executors.newFixedThreadPool(10);
    try {
      for (int j = 0; j < 100; j++) {
        final int index = j;
        executorService.submit(() -> {
          try {
            Thread.sleep(200);
          } catch (InterruptedException e) {
            throw new RuntimeException(e);
          }
          System.out.println("thread %s terminated".formatted(index));
        });
      }
    } finally {
      executorService.shutdown();
    }

    boolean isTerminated = executorService.awaitTermination(1, TimeUnit.SECONDS);
    if (!isTerminated) {
      System.out.println("[before] - isTerminated(): " + executorService.isTerminated());  //false
      executorService.shutdownNow();
      System.out.println("executed shutdownNow");
      System.out.println(
          "[after] - isTerminated(): " + executorService.isTerminated());  //false but might be true
    }
    LockSupport.parkNanos(1_000_000);  //just a try for an alternative way of Thread.sleep
    System.out.println(
        "[after some time] - isTerminated(): " + executorService.isTerminated());  //true
  }

  void sendAnotherTaskAfterShutdown() {
    ExecutorService executorService = Executors.newSingleThreadExecutor();
    try {
      executorService.submit(() -> {
        try {
          Thread.sleep(200);
        } catch (InterruptedException e) {
          throw new RuntimeException(e);
        }
        System.out.println("thread %s terminated");
      });
    } finally {
      executorService.shutdown();
    }
    try {
      //I am submitting another Callable after I have shutdown the executor
      executorService.submit(() -> "hello");
    } catch (Exception e) {
      //java.util.concurrent.RejectedExecutionException
      e.printStackTrace();
    }

  }

}
