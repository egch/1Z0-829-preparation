package org.enricogiurin.ocp17.book.ch13.atomic;

import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Stream;

public class MixedAtomicAndSynchroCounter {

  private AtomicLong atomicCounter = new AtomicLong(0);
  private int simpleCounter;
  private int synchroCounter;

  public static void main(String[] args) {
    new MixedAtomicAndSynchroCounter().increment();
  }

  void increment() {
    Stream.iterate(0, p -> p + 1)
        .parallel()
        .limit(10_000)
        .forEach(n -> {
          atomicCounter.getAndIncrement();
          simpleCounter++;
          synchronized (this) {
            synchroCounter++;
          }
        });

    //a possible output
    //atomicCounter: 10000 - simpleCounter: 9857 - atomicCounter: 10000
    //only simpleCounter can be lower than 10_000
    System.out.println("atomicCounter: %s - simpleCounter: %s - atomicCounter: %s"
        .formatted(atomicCounter, simpleCounter, synchroCounter));
  }

}
