package org.enricogiurin.ocp17.book.ch10;

import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Accumulator {

    public static void main(String[] args) {
        new Accumulator().collectUsingCollectors();
    }

    void collect() {
        Stream<String> stream = Stream.of("1", "2", "3", "2", "1", "9", "4");
        //three arguments
        TreeSet<String> set = stream.collect(TreeSet::new,
                TreeSet::add,
                TreeSet::addAll);
        set.forEach(System.out::print);  //12349
    }


    void collectUsingCollectors() {
        Stream<String> stream = Stream.of("1", "2", "3", "2", "1", "9", "4");
        //one single argument: collector
        TreeSet<String> set = stream.collect(Collectors.toCollection(() -> new TreeSet<String>()));
        set.forEach(System.out::print);  //12349

    }
}
