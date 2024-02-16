package org.enricogiurin.ocp17.book.ch13.executorservice;

import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicInteger;

public class ExecutorServiceInvoke {

  private final AtomicInteger cnt = new AtomicInteger(0);

  public static void main(String[] args)
      throws ExecutionException, InterruptedException, TimeoutException {
    new ExecutorServiceInvoke().invokeAll();
  }

  private List<Callable<String>> buildActions() {
    Callable<String> callable = () -> cnt.getAndIncrement() + "";
    return List.of(callable, callable, callable);

  }


  void invokeAll() throws InterruptedException, ExecutionException, TimeoutException {
    ExecutorService executorService = Executors.newSingleThreadExecutor();
    List<Callable<String>> list = buildActions();
    List<Future<String>> futures;
    try {
      //NOTE: it only accepts Collection<Callable<T>>
      futures = executorService.invokeAll(list);
    } finally {
      executorService.shutdown();
    }
    for (var c : futures) {
      String message = c.get(1, TimeUnit.MINUTES);
      //0, 1, 2
      System.out.println(message);
    }
  }

  void invokeAny() throws InterruptedException, ExecutionException {
    ExecutorService executorService = Executors.newSingleThreadExecutor();
    List<Callable<String>> list = buildActions();
    String message;
    try {
      //NOTE: it only accepts Collection<Callable<T>>
      //note that it returns not a future but the data
      message = executorService.invokeAny(list);
    } finally {
      executorService.shutdown();
    }
    //0
    System.out.println(message);
  }

}


