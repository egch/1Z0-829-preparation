package org.enricogiurin.ocp17.book.ch13;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockPrintHello {

  public static void main(String[] args) throws InterruptedException {
    new LockPrintHello().print();
  }

  void printHello(Lock lock) {
    try {
      lock.lock();
      System.out.println("Hello");
      try {
        Thread.sleep(1000);
      }catch (Exception e){}
    } finally {
      lock.unlock();
    }
  }

  void print() throws InterruptedException {
    //lock with fairness true
    Lock lock = new ReentrantLock(false);
    new Thread(()->printHello(lock)).start();
    try {
      Thread.sleep(100);
    }catch (Exception e){}

    if(lock.tryLock(10, TimeUnit.SECONDS)){
      try {
        System.out.println("lock obtained");
      }finally {
        lock.unlock();
      }
    }else{
      System.out.println("couldn't achieve the lock");
    }
  }

}
