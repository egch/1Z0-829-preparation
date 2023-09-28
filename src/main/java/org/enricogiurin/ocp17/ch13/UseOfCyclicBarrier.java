package org.enricogiurin.ocp17.ch13;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class UseOfCyclicBarrier {

  public static void main(String[] args) {
    new UseOfCyclicBarrier().fourPeopleHavingDinner();
  }

  void fourPeopleHavingDinner() {
    final int numberOfParticipants = 10;
    CyclicBarrier c1 = new CyclicBarrier(numberOfParticipants, () -> System.out.println("-> food is ready!"));
    CyclicBarrier c2 = new CyclicBarrier(numberOfParticipants, () -> System.out.println("-> we have eaten the food"));
    ExecutorService executorService = Executors.newFixedThreadPool(numberOfParticipants);
    try {
      for (int j = 0; j < numberOfParticipants; j++) {
        executorService.submit(() -> dinner(c1, c2));
      }
    } finally {
      executorService.shutdown();
    }
  }

  void dinner(CyclicBarrier c1, CyclicBarrier c2) {
    try {
      System.out.println("cook & prepare the food");
      c1.await();
      System.out.println("eat the food");
      c2.await();
      System.out.println("Clear the table");
    } catch (InterruptedException | BrokenBarrierException e) {
      e.printStackTrace();
    }
  }
}
