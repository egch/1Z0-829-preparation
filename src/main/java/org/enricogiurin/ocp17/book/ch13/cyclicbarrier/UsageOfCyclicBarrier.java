package org.enricogiurin.ocp17.book.ch13.cyclicbarrier;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class UsageOfCyclicBarrier {

  final int numberOfParticipants = 3;
  CyclicBarrier c1;
  CyclicBarrier c2;

  public UsageOfCyclicBarrier() {
    this.c1 = new CyclicBarrier(numberOfParticipants,
        () -> System.out.println("-> food is ready!"));
    this.c2 = new CyclicBarrier(numberOfParticipants,
        () -> System.out.println("-> we have eaten the food"));
  }

  public static void main(String[] args) {
    new UsageOfCyclicBarrier().peopleHavingDinner();
  }

  //possible output
  //cook & prepare the food
  //cook & prepare the food
  //cook & prepare the food
  //-> food is ready!
  //eat the food
  //eat the food
  //eat the food
  //-> we have eaten the food
  //Clear the table
  //Clear the table
  //Clear the table
  void peopleHavingDinner() {
    ExecutorService executorService = Executors.newFixedThreadPool(numberOfParticipants);
    try {
      for (int j = 0; j < numberOfParticipants; j++) {
        executorService.submit(() -> dinner());
      }
    } finally {
      executorService.shutdown();
    }
  }

  void peopleHavingDinnerSingleThread() {

    //one single thread here!
    ExecutorService executorService = Executors.newSingleThreadExecutor();
    //we have one single thread which is waiting here
    //cook & prepare the food.Then the code is hanging.
    try {
      for (int j = 0; j < numberOfParticipants; j++) {
        executorService.submit(() -> dinner());
      }
    } finally {
      executorService.shutdown();
    }

  }

  private void dinner() {
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
