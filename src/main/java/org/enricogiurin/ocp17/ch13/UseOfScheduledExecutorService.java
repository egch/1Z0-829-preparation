package org.enricogiurin.ocp17.ch13;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class UseOfScheduledExecutorService {

  public static void main(String[] args)
      throws ExecutionException, InterruptedException, TimeoutException {
    new UseOfScheduledExecutorService().scheduleCallable();
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

  void scheduleCallable() throws ExecutionException, InterruptedException, TimeoutException {
    ScheduledExecutorService scheduledExecutorService = Executors.newSingleThreadScheduledExecutor();
    ScheduledFuture<String> future;
    try {
      future = scheduledExecutorService.schedule(() -> "ciao", 1,
          TimeUnit.SECONDS);
    } finally {
      scheduledExecutorService.shutdown();
    }
    String result = future.get(2L, TimeUnit.SECONDS);
    System.out.println(result);
  }
}
