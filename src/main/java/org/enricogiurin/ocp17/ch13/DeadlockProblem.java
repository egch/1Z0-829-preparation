package org.enricogiurin.ocp17.ch13;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;

public class DeadlockProblem {

  public static void main(String[] args) throws ExecutionException, InterruptedException {
    new DeadlockProblem().isDeadlock();
  }

  void isDeadlock() throws ExecutionException, InterruptedException {
    Object o1 = new Object();
    Object o2 = new Object();
    var service = Executors.newFixedThreadPool(2);
    try {
      var f1 = service.submit(() -> {
        synchronized (o1) {
          synchronized (o2) {
            System.out.print("Tortoise");
          }
        }
      });
      var f2 = service.submit(() -> {
        synchronized (o2) {
          synchronized (o1) {
            System.out.print("Hare");
          }
        }
      });
      f1.get();
      f2.get();
    } finally {
      service.shutdown();
    }

  }
}
