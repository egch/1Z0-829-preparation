package org.enricogiurin.ocp17.book.ch10;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

public class CommonIntermediateOperations {
    public static void main(String[] args) {
        new CommonIntermediateOperations().peak();
    }
    void distinct() {
        //distinct based on equals
        Stream.of("a", "b", "c", "a", "c")
                .distinct()
                .forEach(System.out::print);  //abc
    }

    void skipAndLimit() {
        Stream.of(1,2,3,4,5,6,7,8,9,10)
                .skip(5L)
                .limit(3L)
                .forEach(System.out::println);  // 6 7 8
    }

    void mapping() {
        //we map a list of sting to a list of integer representing the length of each string
        List<Integer> list = Stream.of("abc", "ashdashh", "asasa")
                .map(s -> s.length())
                .toList();
        list.forEach(System.out::println);  //3 8 5
    }


    void flatMap() {
        List<Integer> listA = List.of(1, 2, 3, 4, 5);
        List<Integer> listB = List.of(6, 7, 8, 9, 10);
        //we merge two list
        Stream.of(listA, listB)
                .flatMap(list -> list.stream())
                .forEach(System.out::println);  //1...10
    }

    void concat() {
        Stream<Integer> streamA = Stream.of(1, 2, 3, 4, 5);
        Stream<Integer> streamB = Stream.of(6, 7, 8, 9, 10);

        //somehow equivalent to flatMap
        Stream<Integer> concat = Stream.concat(streamA, streamB);
        concat.forEach(System.out::println);  //1...10
    }

    void sorted() {
        Integer[] array = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};

        // Convert the array to a List
        List<Integer> list = new ArrayList<>(Arrays.asList(array));

        // Shuffle the list
        Collections.shuffle(list);

        list.stream()
                .sorted()
                .forEach(System.out::println);
    }

    void sortedWithComparator() {
        Integer[] array = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};

        // Convert the array to a List
        List<Integer> list = new ArrayList<>(Arrays.asList(array));

        // Shuffle the list
        Collections.shuffle(list);

        list.stream()
                .sorted((n1, n2)->n2-n1)
                .forEach(System.out::println); //9 ...0
    }

    void peak() {
        Stream.of(0, 1, 2, 3, 4, 5, 6, 7, 8, 9)
                .peek(System.out::println)
                .filter(n->n%2==0)
                .peek(n-> System.out.println("after filter: "+n))
                .toList();
    }
}
