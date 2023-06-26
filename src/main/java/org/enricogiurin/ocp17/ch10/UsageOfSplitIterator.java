package org.enricogiurin.ocp17.ch10;

import java.util.Arrays;
import java.util.List;
import java.util.Spliterator;

public class UsageOfSplitIterator {
    public static void main(String[] args) {
        new UsageOfSplitIterator().use();
    }

    void use() {
        List<String> words = Arrays.asList("Hello", "World", "Java", "Programming");
        Spliterator<String> spliterator = words.spliterator();
        Spliterator<String> spliterator1 = spliterator.trySplit();
        spliterator1.forEachRemaining(System.out::println); //hello world
        //spliterator1.forEachRemaining(System.out::println); //world
        System.out.println("-----");


        //spliterator contains the remaining 2 elements: "Java", "Programming")
        spliterator.tryAdvance(System.out::println); // Prints "Java"
        spliterator.tryAdvance(System.out::println); // Prints "Programming"

    }
}
