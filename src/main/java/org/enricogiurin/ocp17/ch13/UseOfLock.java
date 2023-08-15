package org.enricogiurin.ocp17.ch13;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class UseOfLock {

  public static void main(String[] args) throws ExecutionException, InterruptedException {
    new UseOfLock().showLock();
  }

  void showLock() throws ExecutionException, InterruptedException {
    ExecutorService executorService = Executors.newFixedThreadPool(20);
    final Lock lock = new ReentrantLock();
    try {
      for (int j = 0; j < 20; j++) {
        final int index = j;
        Future<Long> future = executorService.submit(() -> timeWaited(lock, index));
        Long aLong = future.get();
        System.out.println("time: " + aLong);
      }
    } finally {
      executorService.shutdown();
    }
  }

  long timeWaited(Lock lock, int index) throws InterruptedException {
    if (lock.tryLock(1, TimeUnit.MINUTES)) {
      System.out.println("lock acquired for index: " + index);
    } else {
      return -1;
    }

    Thread.sleep(2000);
    lock.unlock();
    System.out.println("lock released for index: " + index);
    return 2000L;
  }
}
