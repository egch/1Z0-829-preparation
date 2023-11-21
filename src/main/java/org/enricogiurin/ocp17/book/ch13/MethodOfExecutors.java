package org.enricogiurin.ocp17.book.ch13;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class MethodOfExecutors {

  Runnable runnable = () -> {
    try {
      Thread.sleep(1000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  };

  public static void main(String[] args) throws InterruptedException {
    MethodOfExecutors methodOfExecutors = new MethodOfExecutors();
    methodOfExecutors.newSingleThreadExecutor();
    methodOfExecutors.newFixedThreadPool();
    methodOfExecutors.newCachedThreadPool();
  }

  void newCachedThreadPool() throws InterruptedException {
    //all tasks completed
    //time taken: 1006
    ExecutorService executorService = Executors.newCachedThreadPool();
    execute(executorService);
  }

  void newSingleThreadExecutor() throws InterruptedException {
    //all tasks completed
    //time taken: 10038

    ExecutorService executorService = Executors.newSingleThreadExecutor();
    execute(executorService);
  }

  void newFixedThreadPool() throws InterruptedException {
    //all tasks completed
    //time taken: 2006
    ExecutorService executorService = Executors.newFixedThreadPool(5);
    execute(executorService);
  }

  void execute(ExecutorService executorService) throws InterruptedException {
    long start = System.currentTimeMillis();

    try {
      for (int j = 0; j < 10; j++) {
        executorService.execute(runnable);
      }
    } finally {
      executorService.shutdown();
    }
    executorService.awaitTermination(1, TimeUnit.MINUTES);
    if (executorService.isTerminated()) {
      System.out.println("all tasks completed");
    }
    System.out.println("time taken: " + (System.currentTimeMillis() - start));
  }

}
