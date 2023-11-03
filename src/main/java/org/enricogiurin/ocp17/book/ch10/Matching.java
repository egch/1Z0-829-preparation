package org.enricogiurin.ocp17.book.ch10;

import java.util.stream.Stream;

public class Matching {

    public static void main(String[] args) {
        new Matching().noneMatch();
    }
    void anyMatch() {
        boolean greater = Stream.iterate(1, n -> n + 1)
                .anyMatch(n -> n > 5);
        System.out.println(greater);
    }

    void allMatch() {
        boolean allEven = Stream.of(2, 4, 6, 8)
                .allMatch(n -> n % 2 == 0);
        System.out.println(allEven);
    }

    void noneMatch() {
        boolean noGreater = Stream.iterate(2, n -> n * 2)
                .noneMatch(n -> n > 10);
        System.out.println(noGreater);
    }
}
