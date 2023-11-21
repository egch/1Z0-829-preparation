package org.enricogiurin.ocp17.book.ch13;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class SingleThreadExecutor {

  Runnable printInventory = () -> System.out.println("Printing zoo inventory");
  Runnable printRecords = () -> {
    for (int i = 0; i < 100; i++) {
      System.out.println("Printing record: " + i);
    }
  };

  public static void main(String[] args) throws InterruptedException {
    new SingleThreadExecutor().awaitTermination();
  }

  void executor() {
    //a single thread
    ExecutorService executorService = Executors.newSingleThreadExecutor();
    System.out.println("start!");
    try {
      executorService.execute(printInventory);
      executorService.execute(printRecords);
      executorService.execute(printInventory);
      System.out.println("end!");
    } finally {
      //it's important to call it
      //otherwise the application will never end
      executorService.shutdown();
      System.out.println("shutdown!");
    }

    //try to submit a task after the shutdown
    try {
      executorService.execute(() -> System.out.println("hello"));
    } catch (Exception e) {
      //java.util.concurrent.RejectedExecutionException: Task java.util.concurrent.FutureTask@85ede7b[Not completed,
      e.printStackTrace();
    }
  }

  void shutdownNow() {
    ExecutorService executorService = Executors.newSingleThreadExecutor();
    try {
      executorService.execute(printRecords);
    } finally {
      executorService.shutdownNow();
      System.out.println("shutdown!");
    }
  }

  void awaitTermination() throws InterruptedException {
    ExecutorService executorService = Executors.newSingleThreadExecutor();
    try {
      executorService.execute(printRecords);
    } finally {
      executorService.shutdownNow();
      System.out.println("shutdown!");
    }
    boolean terminated = executorService.awaitTermination(1L, TimeUnit.MICROSECONDS);
    if (executorService.isTerminated()) {
      System.out.println("we are done");
    } else {
      System.out.println("at least one task is still going");
    }
  }
}

