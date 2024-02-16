package org.enricogiurin.ocp17.book.ch13.executorservice;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class UsageOfExecutorService {

  public static void main(String[] args)
      throws ExecutionException, InterruptedException, TimeoutException {
    new UsageOfExecutorService().execute();
  }

  void execute() {
    Runnable runnable = () -> {
      try {
        Thread.sleep(200);
        System.out.println("Task completed!");
      } catch (InterruptedException e) {
        throw new RuntimeException(e);
      }
    };
    //execute() only accepts Runnable (NOT Callable)
    ExecutorService executorService = Executors.newSingleThreadExecutor();
    try {
      executorService.execute(runnable);
    } finally {
      executorService.shutdown();
    }
  }

  void submitWithRunnable() throws ExecutionException, InterruptedException {
    ExecutorService executorService = Executors.newSingleThreadExecutor();
    Future<?> future;
    try {
      future = executorService.submit(() -> System.out.println("hello"));
    } finally {
      executorService.shutdown();
    }
    //get on a Future<?> returns null
    Object nullObject = future.get();
    //null
    System.out.println(nullObject);
  }

  void submitWithCallable() throws ExecutionException, InterruptedException, TimeoutException {
    ExecutorService executorService = Executors.newSingleThreadExecutor();
    Future<String> future;
    try {
      future = executorService.submit(() -> "done");
    } finally {
      executorService.shutdown();
    }
    //keep in mind that get() is blocking
    String result = future.get(1, TimeUnit.SECONDS);
    System.out.println(result);
  }

}
