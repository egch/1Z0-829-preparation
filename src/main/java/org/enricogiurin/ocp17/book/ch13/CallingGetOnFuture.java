package org.enricogiurin.ocp17.book.ch13;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CallingGetOnFuture {

  public static void main(String[] args) throws ExecutionException, InterruptedException {
    new CallingGetOnFuture().execute();
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

}
