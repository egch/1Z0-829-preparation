package org.enricogiurin.ocp17.book.ch13;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Different ways to print values from 1 to 20
 */
public class IncrementAndPrint {

  public static void main(String[] args) {
    //a possible output
    //20 10 7 19 14 5 8 11 15 18 13 2 3 4 12 17 6 1 16 9
    //missing values or even duplicate values

    //new UseOfAtomicClass().possibleDuplicateOrMissingValues();
    // new IncrementAndPrint().neitherDuplicateNorMissingValues();
    // new IncrementAndPrint().rightOrder();
    new IncrementAndPrint().rightOrder();
  }

  //order is not kept but neither duplicate nor missing
  void possibleDuplicateOrMissingValues() {
    ExecutorService executorService = Executors.newFixedThreadPool(20);
    Wrapper wrapper = new Wrapper();
    try {
      for (int j = 0; j < 20; j++) {
        executorService.submit(wrapper::incrementAndPrint);
      }
    } finally {
      executorService.shutdown();
    }
  }

  void neitherDuplicateNorMissingValues() {
    ExecutorService executorService = Executors.newFixedThreadPool(20);
    WrapperAtomicInteger wrapperAtomicInteger = new WrapperAtomicInteger();
    try {
      for (int j = 0; j < 20; j++) {
        executorService.submit(wrapperAtomicInteger::incrementAndPrint);
      }
    } finally {
      executorService.shutdown();
    }
  }

  void rightOrder() {
    ExecutorService executorService = Executors.newFixedThreadPool(20);
    SynchronizedWrapper synchronizedWrapper = new SynchronizedWrapper();
    try {
      for (int j = 0; j < 20; j++) {
        executorService.submit(synchronizedWrapper::incrementAndPrint);
      }
    } finally {
      executorService.shutdown();
    }
  }

  void rightOrderWithLock() {
    ExecutorService executorService = Executors.newFixedThreadPool(20);
    SynchronizedLockWrapper synchronizedLockWrapper = new SynchronizedLockWrapper();
    try {
      for (int j = 0; j < 20; j++) {
        executorService.submit(synchronizedLockWrapper::incrementAndPrint);
      }
    } finally {
      executorService.shutdown();
    }
  }


  static class Wrapper {

    private int counter;

    void incrementAndPrint() {
      System.out.print(++counter + " ");
    }
  }

  static class WrapperAtomicInteger {

    AtomicInteger atomicInteger = new AtomicInteger(0);

    void incrementAndPrint() {
      System.out.print(atomicInteger.incrementAndGet() + " ");
    }
  }

  static class SynchronizedWrapper {

    private int counter;

    void incrementAndPrint() {
      synchronized (this) {
        System.out.print(++counter + " ");
      }
    }
  }

  //this solution works as well
  static class SynchronizedLockWrapper {

    private final Object lock = new Object();
    private int counter;

    void incrementAndPrint() {
      synchronized (lock) {
        System.out.print(++counter + " ");
      }
    }
  }
}


