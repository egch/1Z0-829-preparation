package org.enricogiurin.ocp17.ch13;

import java.util.List;

public class ParallelStream {

    public static void main(String[] args) {
        //new ParallelStream().calculate();
        //new ParallelStream().calculateParallel();
        new ParallelStream().calculateParallelOrdered();
    }

    void calculate() {
        long start = System.currentTimeMillis();
        List<Integer> list = List.of(1, 2, 3, 4, 5);
        list.stream()
                .map(this::pow2)
                .forEach(s-> System.out.print(s+" "));
        System.out.println();
        long time = System.currentTimeMillis() - start;
        System.out.println("time taken: "+time+" seconds");
    }

    //faster but order not guaranteed
/*    25 16 4 9 1
    time taken: 1026 seconds*/
    void calculateParallel() {
        long start = System.currentTimeMillis();
        List<Integer> list = List.of(1, 2, 3, 4, 5);
        list.parallelStream()
                .map(this::pow2)
                .forEach(s-> System.out.print(s+" "));
        System.out.println();
        long time = System.currentTimeMillis() - start;
        System.out.println("time taken: "+time+" seconds");
    }

    //faster and order guaranteed
    //1 4 9 16 25
    //time taken: 1019 seconds
    void calculateParallelOrdered() {
        long start = System.currentTimeMillis();
        List<Integer> list = List.of(1, 2, 3, 4, 5);
        list.parallelStream()
                .map(this::pow2)
                .forEachOrdered(s-> System.out.print(s+" "));
        System.out.println();
        long time = System.currentTimeMillis() - start;
        System.out.println("time taken: "+time+" seconds");
    }
    int pow2(int value){
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return value * value;
    }
}
