package org.enricogiurin.ocp17.book.ch10;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import org.enricogiurin.ocp17.various.helper.Enthuware;

public class CommonIntermediateOperations {

  public static void main(String[] args) {
    new CommonIntermediateOperations().min();
  }

  void distinct() {
    //distinct based on equals
    Stream.of("a", "b", "c", "a", "c")
        .distinct()
        .forEach(System.out::print);  //abc
  }

  void skipAndLimit() {
    Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
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


  void concat() {
    Stream<Integer> streamA = Stream.of(1, 2, 3, 4, 5);
    Stream<Integer> streamB = Stream.of(6, 7, 8, 9, 10);

    //somehow equivalent to flatMap
    Stream<Integer> concat = Stream.concat(streamA, streamB);
    int sum = concat
        .peek(System.out::println) //1,2...10
        .mapToInt(n -> n)
        .sum();
    System.out.println(sum); //55
  }

  void concatWithIntStream() {
    IntStream odds = IntStream.iterate(1, a -> a + 2);
    IntStream evens = IntStream.iterate(2, a -> a + 2);
    //only the odds will be considered
    int sum = IntStream.concat(odds, evens)
        .limit(3)
        .sum();
    System.out.println(sum);  //9

    //does not work with normal Stream.concat
    //Stream.concat(odds, evens)  //does not compile
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
        .sorted((n1, n2) -> n2 - n1)
        .forEach(System.out::println); //9 ...0
  }


  void sortedComparatorReverseOrder() {
    Comparator<String> stringComparator = Comparator.reverseOrder();
    var s = Stream.of("a",
        "t1",
        "t2");
    s.filter(n -> n.startsWith("t"))
        // .sorted(Comparator::reverseOrder)  //does not compile like this
        .sorted(stringComparator)
        .findFirst()
        .ifPresent(System.out::println); //t2
  }

  void aboutSortedComparatorReverseOrder() {
    Runnable reverseOrder = Comparator::reverseOrder;
    Comparator<String> comparator = Comparator.reverseOrder();
  }

  void peak() {
    Stream.of(0, 1, 2, 3, 4, 5, 6, 7, 8, 9)
        .peek(System.out::println)
        .filter(n -> n % 2 == 0)
        .peek(n -> System.out.println("after filter: " + n))
        .toList();
  }

  @Enthuware
  void max() {
    List<String> list = List.of("a", "ab", "abc", "kk");
    Optional<String> optMax = list.stream()
        .max((String s1, String s2) -> s1.length() - s2.length());
    optMax.ifPresent(s -> System.out.println(s)); //abc

    //similar way
    Comparator<String> comparator = Comparator.comparing(String::length);
    optMax = list.stream()
        .max(comparator);
    optMax.ifPresent(s -> System.out.println(s)); //abc
  }

  void min() {
    //note that this is a Stream<Integer>, not IntStream
    Stream<Integer> stream = Stream.of(10, 12, 45, 79);
    Optional<Integer> optMin = stream
        .min((n1, n2) -> n1 - n2);
    optMin.ifPresent(System.out::println);  //10

  }
}
