package org.enricogiurin.ocp17.book.ch13;

public class CheckCounter {

  private static int counter = 0;

  static final int COUNT_TO = 1_000_000_000;

  public static void main(String[] a) {
    Thread mainThread = Thread.currentThread();
    Thread thread = new Thread(() -> {
      for (int i = 0; i < COUNT_TO; i++) {
        counter++;
      }
      //I do interrupt the main thread when I am done
      //so I can exit the main once I reached the 1 million counter
      mainThread.interrupt();
      System.out.println("main thread interrupted");

    });
    thread.start();

    //here I monitor the counter
    while (counter < COUNT_TO) {
      System.out.println("counter: "+counter);
      try {
        System.out.println("state: " + thread.getState());
        Thread.sleep(1); //1ms
      } catch (InterruptedException e) {
        System.out.println("Interrupted!");
      }
    }
    System.out.println("[end]state: " + thread.getState());
    System.out.println("[end]counter: "+counter);
    //state: TERMINATED

  }
}
