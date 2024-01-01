package org.enricogiurin.ocp17.book.ch13.cyclicbarrier;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CyclicBarrierSingleThread {

  public static void main(String[] args) {
    new CyclicBarrierSingleThread().singleThread();
  }

  private void wait(CyclicBarrier cyclicBarrier) {
    System.out.println("waiting");
    try {
      cyclicBarrier.await();
    } catch (BrokenBarrierException | InterruptedException e) {
      throw new RuntimeException(e);
    }
    System.out.println("done");
  }

  void singleThread() {
    CyclicBarrier cyclicBarrier = new CyclicBarrier(4, () -> System.out.println("completed"));
    //here we are intentionally using newSingleThreadExecutor
    ExecutorService executorService = Executors.newSingleThreadExecutor();
    try {
      for (int j = 0; j < 4; j++) {
        //this thread hangs forever because the CB needs 4 threads and we have only one
        executorService.submit(() -> wait(cyclicBarrier));
      }
    } finally {
      executorService.shutdown();
    }
  }

}
