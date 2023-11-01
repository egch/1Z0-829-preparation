package org.enricogiurin.ocp17.ch13;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class UseOfCallable {

  public static void main(String[] args) {
    new UseOfCallable().submit();
  }

  void submit() {
    Callable<String> forCallable = () -> {
      for (int j = 0; j < 1_000; j++) {
        System.out.print(j + " ");
      }
      System.out.println();
      return "done";
    };
    ExecutorService executorService = Executors.newSingleThreadExecutor();
    try {
      Future<String> future = executorService.submit(forCallable);
      String result = future.get(1L, TimeUnit.SECONDS);
      System.out.println(result);
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      executorService.shutdown();
    }
  }

  void simpleCallable(){
    Callable<String> callable = ()->"hello";
  }
}

