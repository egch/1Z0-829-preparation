package org.enricogiurin.ocp17.book.ch13.thread;

public class InterruptThread {

  public static void main(String[] args) throws InterruptedException {
    new InterruptThread().interruptCGPT();
  }

  void interruptCGPT() {
    Thread workerThread = new Thread(() -> {
      try {
        System.out.println("Worker thread started.");
        // Simulate a time-consuming task
        for (int i = 0; i < 5; i++) {
          if (Thread.interrupted()) {
            System.out.println("Worker thread has been interrupted.");
            return; // Exit the thread when interrupted
          }
          System.out.println("Working on task " + i);
          Thread.sleep(1000); // Simulate work (1 second)
        }
        System.out.println("Worker thread completed.");
      } catch (InterruptedException e) {
        System.out.println("Worker thread interrupted while sleeping.");
      }
    });

    workerThread.start();

    // Main thread waits for a while and then interrupts the worker thread
    try {
      System.out.println("[before]state worker thread: " + workerThread.getState().name());
      Thread.sleep(3000); // Wait for 3 seconds
      System.out.println("[after]state worker thread: " + workerThread.getState().name());
      workerThread.interrupt(); // Interrupt the worker thread
      System.out.println("[after interrupt]state worker thread: " + workerThread.getState().name());
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

  }
}
