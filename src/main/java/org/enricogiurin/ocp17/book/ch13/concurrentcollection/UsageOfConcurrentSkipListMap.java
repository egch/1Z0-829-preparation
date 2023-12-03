package org.enricogiurin.ocp17.book.ch13.concurrentcollection;

import java.util.concurrent.ConcurrentSkipListMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class UsageOfConcurrentSkipListMap {

  public static void main(String[] args) throws InterruptedException {
    new UsageOfConcurrentSkipListMap().usage();
  }

  void usage() throws InterruptedException {
    //reverse order
    ConcurrentSkipListMap<Integer, String> map = new ConcurrentSkipListMap<>((n1, n2) -> n2 - n1);
    ExecutorService executorService = Executors.newCachedThreadPool();
    for (int j = 0; j < 100; j++) {
      final int index = j;
      executorService.submit(() -> map.put(index, index % 2 == 0 ? "even" : "odd"));
    }
    executorService.shutdown();
    boolean awaitTermination = executorService.awaitTermination(1, TimeUnit.SECONDS);
    if (awaitTermination) {
      //they are printed from 99 to 0
      map.forEach((k, v) -> System.out.println("key: %s - value: %s".formatted(k, v)));
    }
  }

}
