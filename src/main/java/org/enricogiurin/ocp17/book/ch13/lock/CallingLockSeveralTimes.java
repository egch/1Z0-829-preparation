package org.enricogiurin.ocp17.book.ch13.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class CallingLockSeveralTimes {

  private Lock lock = new ReentrantLock();

  public static void main(String[] args) {
    new CallingLockSeveralTimes().usage();
  }

  //only the first thread will get the lock
  void lockTwice() {
    String threadName = Thread.currentThread().getName();
    System.out.println("current thread: " + threadName);
    if (lock.tryLock()) {
      System.out.println("thread " + threadName + " get the lock");
      lock.lock();  //again lock
      lock.unlock();  //still one lock is active
    }

  }

  //possible output
  //current thread: 0
  //current thread: 1
  //current thread: 2
  //current thread: 3
  //current thread: 4
  //thread 0 get the lock
  void usage() {
    for (int j = 0; j < 5; j++) {
      Thread thread = new Thread(this::lockTwice);
      thread.setName(j + "");
      try {
        Thread.sleep(20);
      } catch (InterruptedException e) {
        throw new RuntimeException(e);
      }
      thread.start();
    }
  }

}
