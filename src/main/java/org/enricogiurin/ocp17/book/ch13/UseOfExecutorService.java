package org.enricogiurin.ocp17.book.ch13;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class UseOfExecutorService {

  public static void main(String[] args) throws ExecutionException, InterruptedException {
    new UseOfExecutorService().submit();
  }

  void submit() throws ExecutionException, InterruptedException {
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

}
