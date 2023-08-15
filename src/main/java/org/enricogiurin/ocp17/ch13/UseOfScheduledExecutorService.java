package org.enricogiurin.ocp17.ch13;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class UseOfScheduledExecutorService {

  public static void main(String[] args) {
    new UseOfScheduledExecutorService().schedule();
  }

  //done
  //hello
  void schedule() {
    ScheduledExecutorService scheduledExecutorService = Executors.newSingleThreadScheduledExecutor();

    try {
      scheduledExecutorService.schedule(() -> System.out.println("hello"), 2L, TimeUnit.SECONDS);
    } finally {
      scheduledExecutorService.shutdown();
    }
    System.out.println("done");
  }
}
