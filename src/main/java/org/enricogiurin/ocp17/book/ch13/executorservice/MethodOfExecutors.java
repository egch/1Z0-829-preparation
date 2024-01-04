package org.enricogiurin.ocp17.book.ch13.executorservice;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class MethodOfExecutors {


  Callable<String> callable = () -> {
    try {
      Thread.sleep(1000);
      return "I am done!";
    } catch (InterruptedException e) {
      e.printStackTrace();
      return "I screwed up";
    }
  };

  public static void main(String[] args)
      throws InterruptedException, ExecutionException, TimeoutException {
    MethodOfExecutors methodOfExecutors = new MethodOfExecutors();
    //methodOfExecutors.newSingleThreadExecutor();
    //methodOfExecutors.newFixedThreadPool();
    methodOfExecutors.newCachedThreadPool();
  }

  void newCachedThreadPool() throws InterruptedException, ExecutionException, TimeoutException {
    //all tasks completed
    //time taken: 1006
    ExecutorService executorService = Executors.newCachedThreadPool();
    execute(executorService);
  }

  void newSingleThreadExecutor() throws InterruptedException, ExecutionException, TimeoutException {
    //all tasks completed
    //time taken: 10038

    ExecutorService executorService = Executors.newSingleThreadExecutor();
    execute(executorService);
  }

  void newFixedThreadPool() throws InterruptedException, ExecutionException, TimeoutException {
    //all tasks completed
    //time taken: 2006
    ExecutorService executorService = Executors.newFixedThreadPool(5);
    execute(executorService);
  }

  void execute(ExecutorService executorService)
      throws InterruptedException, ExecutionException, TimeoutException {
    long start = System.currentTimeMillis();
    List<Future<String>> collector = new ArrayList<>(10);

    try {
      for (int j = 0; j < 10; j++) {
        Future<String> future = executorService.submit(callable);
        collector.add(future);
      }
    } finally {
      executorService.shutdown();
    }
    boolean awaitTermination = executorService.awaitTermination(1, TimeUnit.MINUTES);
    if (executorService.isTerminated()) {
      System.out.println("all tasks completed");
    }
    for(Future<String> future:collector){
      String result = future.get(1, TimeUnit.SECONDS);
      System.out.println(result);
    }
    System.out.println("time taken: " + (System.currentTimeMillis() - start));
  }

  void allMethods() {
    ExecutorService executorService = Executors.newSingleThreadExecutor();
    ExecutorService cachedExecutorService = Executors.newCachedThreadPool();
    ExecutorService fixedExecutorService = Executors.newFixedThreadPool(10);
    //scheduled methods
    ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(10);
    ScheduledExecutorService singleScheduledExecutorService = Executors.newSingleThreadScheduledExecutor();
  }

}
