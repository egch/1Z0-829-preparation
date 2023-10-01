package org.enricogiurin.ocp17.ch13.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.IntStream;

public class BankLock {

  private Lock vault = new ReentrantLock();
  private int total = 0;

  public void deposit(int value) {
    try {
      vault.tryLock();
      total += value;
    } finally {
      vault.unlock();
    }
  }

  //possible outcome:
  // - it prints 45
  // - java.lang.IllegalMonitorStateException is thrown
  public static void main(String[] unused) {
    var bank = new BankLock();
    IntStream.range(1, 10).parallel()
        .forEach(s -> bank.deposit(s));
    System.out.println(bank.total);
  }
}
