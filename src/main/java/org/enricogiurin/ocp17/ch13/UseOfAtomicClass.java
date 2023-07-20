package org.enricogiurin.ocp17.ch13;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class UseOfAtomicClass {

    public static void main(String[] args) {
        //a possible output
        //20 10 7 19 14 5 8 11 15 18 13 2 3 4 12 17 6 1 16 9
        //missing values or even duplicate values

        //new UseOfAtomicClass().possibleDuplicateOrMissingValues();
        new UseOfAtomicClass().neitherDuplicateNorMissingValues();
    }

    //order is not kept but neither duplicate nor missing
    void possibleDuplicateOrMissingValues() {
        ExecutorService executorService = Executors.newFixedThreadPool(20);
        Wrapper wrapper = new Wrapper();
        try {
            for (int j = 0; j < 20; j++) {
                executorService.submit(wrapper::incrementAndPrint);
            }
        } finally {
            executorService.shutdown();
        }
    }

    void neitherDuplicateNorMissingValues() {
        ExecutorService executorService = Executors.newFixedThreadPool(20);
        AtomicInteger atomicInteger = new AtomicInteger(0);
        try {
            for (int j = 0; j < 20; j++) {
                executorService.submit(() -> System.out.print(atomicInteger.incrementAndGet() + " "));
            }
        } finally {
            executorService.shutdown();
        }

    }
}

class Wrapper {
    private int counter;

    void incrementAndPrint() {
        System.out.println(++counter + " ");
    }
}
