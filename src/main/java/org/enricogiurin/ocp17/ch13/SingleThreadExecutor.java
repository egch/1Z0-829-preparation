package org.enricogiurin.ocp17.ch13;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SingleThreadExecutor {

    Runnable printInventory = () -> System.out.println("Printing zoo inventory");
    Runnable printRecords = () -> {
        for (int i = 0; i < 3; i++) System.out.println("Printing record: " + i);
    };

    public static void main(String[] args) {
        new SingleThreadExecutor().executor();
    }

    void executor() {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        try {
            executorService.submit(printInventory);
            executorService.submit(printRecords);
            executorService.submit(printInventory);
            System.out.println("finished!");
        } finally {
            executorService.shutdown();
        }
    }
}
