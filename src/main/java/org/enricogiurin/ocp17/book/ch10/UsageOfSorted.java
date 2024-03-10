package org.enricogiurin.ocp17.book.ch10;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

public class UsageOfSorted {


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

  /**
   * sorted(), without Comparator, needs to have a natural order, which can only be provided
   * if the elements implement Comparable.
   */
  void sortedOfNotComparable() {
    //my record does not implement Comparable
    record Name(String name){}
    List<Name> list = Arrays.asList(new Name("John"), new Name("Mark"), new Name("Philip"));
    //java.lang.ClassCastException: class org.enricogiurin.ocp17.book.ch10.CommonIntermediateOperations$1Name cannot be cast to class java.lang.Comparable
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

}
