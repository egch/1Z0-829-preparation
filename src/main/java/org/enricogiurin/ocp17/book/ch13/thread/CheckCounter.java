package org.enricogiurin.ocp17.book.ch13.thread;

public class CheckCounter {

  static final int COUNT_TO = 1_000_000_000;
  private static int counter = 0;

  public static void main(String[] a) {
    Thread mainThread = Thread.currentThread();
    Thread thread = new Thread(() -> {
      for (int i = 0; i < COUNT_TO; i++) {
        counter++;
      }
      //I do interrupt the main thread when I am done
      //so I can exit the main once I reached the 1 million counter
      System.out.println("Interrupting the main thread...");
      mainThread.interrupt();
    });
    thread.start();

    //here I monitor the counter
    while (counter < COUNT_TO) {
      System.out.println("counter: " + counter);
      try {
        System.out.println("state: " + thread.getState());
        Thread.sleep(5); //5ms
      } catch (InterruptedException e) {
        System.out.println("main thread interrupted!");
      }
    }
    System.out.println("[end]state: " + thread.getState());
    System.out.println("[end]counter: " + counter);
    //state: TERMINATED
  }
}

//one of the possible last outputs

//counter: 822600014
//state: RUNNABLE
//counter: 959651629
//state: RUNNABLE
//Interrupting the main thread...
//main thread interrupted
//[end]state: TERMINATED
//[end]counter: 1000000000