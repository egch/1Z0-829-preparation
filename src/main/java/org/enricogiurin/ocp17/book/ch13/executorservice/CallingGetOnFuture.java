package org.enricogiurin.ocp17.book.ch13.executorservice;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class CallingGetOnFuture {

  public static void main(String[] args) throws ExecutionException, InterruptedException {
    new CallingGetOnFuture().generateRandom();
  }

  private void task() {
    System.out.println("started");
    try {
      Thread.sleep(100);
      System.out.println("completed");
    } catch (InterruptedException e) {
    }
  }

  //the threads are executed sequentially because the Future.get() blocks the execution
  void execute() throws ExecutionException, InterruptedException {
    ExecutorService executorService = Executors.newCachedThreadPool();
    for (int j = 0; j < 100; j++) {
      System.out.println("starting thread " + j);
      //I invoke the get on the future
      executorService.submit(() -> task()).get();
    }
    executorService.shutdown();
  }
  //code is a sequence of this:
  //starting thread N
  //started
  //completed

  void generateRandom() throws InterruptedException {
    Random random = new Random();
    class Generator {

      double random() {
        double randomValue = random.nextDouble();
        try {
          Thread.sleep(random.nextInt(100));
          ;
        } catch (InterruptedException e) {
        }
        return randomValue;
      }
    }
    Generator generator = new Generator();
    List<Future<Double>> futures = new ArrayList<>();
    ExecutorService executorService = Executors.newFixedThreadPool(5);
    try {
      for (int j = 0; j < 100; j++) {
        Future<Double> doubleFuture = executorService.submit(() -> generator.random());
        futures.add(doubleFuture);
      }
    } finally {
      executorService.shutdown();
    }
    boolean awaitTermination = executorService.awaitTermination(10, TimeUnit.SECONDS);
    if (awaitTermination && executorService.isTerminated()) {
      futures.forEach(f -> {
        try {
          Double aDouble = f.get();
          System.out.println(aDouble);
        } catch (InterruptedException | ExecutionException e) {
        }
      });
    }
  }

}
