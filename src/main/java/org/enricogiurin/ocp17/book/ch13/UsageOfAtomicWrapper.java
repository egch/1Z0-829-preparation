package org.enricogiurin.ocp17.book.ch13;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.IntStream;

public class UsageOfAtomicWrapper {

  public static void main(String[] args) throws InterruptedException {
    new UsageOfAtomicWrapper().atomicBoolean();
  }

  //one of possible results
  //100 91
  void undeterminedResult() {
    var value1 = new AtomicLong(0);
    final long[] value2 = {0};
    IntStream.iterate(1, i -> 1).limit(100).parallel()
        .forEach(i -> value1.incrementAndGet());
    IntStream.iterate(1, i -> 1).limit(100).parallel()
        .forEach(i -> ++value2[0]);

    //the first will always be 100 as it uses AtomicLong
    //the second is undetermined
    System.out.println(value1 + " " + value2[0]);
  }

  void atomicBoolean() throws InterruptedException {
    AtomicBoolean atomicBoolean = new AtomicBoolean(false);
    //The flip() method first retrieves the value and then sets a new value.
    // These two calls are not executed together in an atomic or synchronized manner.
    Runnable flip = () ->
        atomicBoolean.getAndSet(!atomicBoolean.get());

    ExecutorService executorService = Executors.newCachedThreadPool();
    for (int j = 0; j < 100; j++) {
      executorService.submit(flip);
    }
    executorService.shutdown();
    executorService.awaitTermination(1, TimeUnit.MINUTES);
    //the result is not predictable... true/false
    System.out.println(atomicBoolean.get());
  }
}
