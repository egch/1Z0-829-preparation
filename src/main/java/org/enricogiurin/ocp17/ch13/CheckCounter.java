package org.enricogiurin.ocp17.ch13;

public class CheckCounter {
    private static int counter = 0;

    public static void main(String[] a) {
        Thread thread = new Thread(() -> {
            for (int i = 0; i < 1_000_000; i++) {
                counter++;
            }
        });
        thread.start();
        while (counter < 1_000_000) {
            System.out.println("Not reached yet");
            try {
                System.out.println("state: " + thread.getState());
                Thread.sleep(1); //1ms
            } catch (InterruptedException e) {
                System.out.println("Interrupted!");
            }
        }
        System.out.println("state: " + thread.getState());
        //state: TERMINATED
        System.out.println("Reached: " + counter);
    }
}
