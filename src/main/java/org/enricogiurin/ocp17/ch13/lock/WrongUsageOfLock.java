package org.enricogiurin.ocp17.ch13.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.IntStream;

public class WrongUsageOfLock {

  private Lock vault = new ReentrantLock();
  private int total = 0;

  public static void main(String[] unused) {
    var instance = new WrongUsageOfLock();
    IntStream.range(1, 10).parallel()
        .forEach(instance::acquireLock);
    System.out.println(instance.total);
  }

  public void acquireLock(int value) {
    try {
      //wrong - we do not consider the output of this: true/false
      vault.tryLock();
      total += value;
    } finally {
      //if the lock is not previously acquired this can end up ina an exception
      //Exception in thread "main" java.lang.IllegalMonitorStateException
      vault.unlock();
    }
  }
}