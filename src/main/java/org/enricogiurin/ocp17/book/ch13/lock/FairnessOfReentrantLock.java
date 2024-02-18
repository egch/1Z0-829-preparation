package org.enricogiurin.ocp17.book.ch13.lock;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class FairnessOfReentrantLock {

  public static void main(String[] args) {
    new FairnessOfReentrantLock().execute();
  }
  void fair() {
    ReentrantLock lock1 = new ReentrantLock();
    System.out.println(lock1.isFair());

    ReentrantLock lock2 = new ReentrantLock(true);  //false
    System.out.println(lock2.isFair());  //true
  }


  //I observe the behavior is the same, no matter if fair is set to true or false
  void execute() {
    ReentrantLock lock = new ReentrantLock(true);
    ExecutorService executorService = Executors.newCachedThreadPool();
    try {
      for (int j = 0; j < 10; j++) {
        final int index = j;
        executorService.submit(()->task(index, lock));
        try {
          Thread.sleep(10);
        } catch (InterruptedException e) {
          throw new RuntimeException(e);
        }
      }
    } finally {
      executorService.shutdown();
    }
  }

  private void task(int index, Lock lock) {
    lock.lock();
    try {
      Thread.sleep(1_000);
      System.out.println("completed task n: "+index);
    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    }finally {
      lock.unlock();
    }
  }

}
