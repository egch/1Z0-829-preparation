package org.enricogiurin.ocp17.book.ch13.executorservice;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class FutureWithCallable {

  public static void main(String[] args) {
    new FutureWithCallable().future();
  }

  void future() {
    //this is valid
    Callable<Double> callablePi = () -> Math.PI;
    //also this is valid
    Callable<Object> callablePiObject = () -> Math.PI;

    ExecutorService executorService = Executors.newFixedThreadPool(2);

    //I can also use a Future<Object> rather than Future<Double>
    //they are both valid
    Future<Object> f1 = executorService.submit(() -> Math.PI);
    Future<Double> f2 = executorService.submit(() -> Math.PI);

    try {
      Object o = f1.get();
      Double d = f2.get();
      System.out.println(o);  //3.141592653589793
      System.out.println(d);  //3.141592653589793
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      executorService.shutdown();
    }
  }

}
