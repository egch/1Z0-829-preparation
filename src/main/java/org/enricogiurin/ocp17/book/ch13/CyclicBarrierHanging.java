package org.enricogiurin.ocp17.book.ch13;

import java.util.concurrent.CyclicBarrier;
import java.util.stream.IntStream;

public class CyclicBarrierHanging {

  final int NUM_THREADS = 30;
  //my mac has 12 processors so having limit barrier greater makes
  //the code hanging, no matter the number of threads
  final int LIMIT_BARRIER = 10;

  public static void main(String[] args) {
    new CyclicBarrierHanging().hanging();
  }

  private void await(CyclicBarrier cb) {
    try {
      cb.await();
    } catch (Exception e) {
    }
  }

  void hanging() {
    var cb = new CyclicBarrier(LIMIT_BARRIER,
        () -> System.out.println("Stock Room Full!")); // j2
    IntStream.iterate(1, i -> 1)
        .limit(NUM_THREADS)
        .parallel()
        .forEach(i -> await(cb)); // j3

  }

}
