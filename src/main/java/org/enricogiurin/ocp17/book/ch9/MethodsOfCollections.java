package org.enricogiurin.ocp17.book.ch9;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MethodsOfCollections {

  public static void main(String[] args) {
    new MethodsOfCollections().binarySearchWithComparator();

  }

  void binarySearch() {
    //list needs to be sorted
    List<Integer> list = buildList();
    int index = Collections.binarySearch(list, 3);
    System.out.println(index);  //2 - position 2
    index = Collections.binarySearch(list, 1); //1 is not present!
    //index = -pos -1 = -1 -1 = -2
    System.out.println(index);
  }

  void binarySearchWithComparator() {
    //list needs to be sorted ...according to the comparator to be used
    List<Integer> list = Arrays.asList(20, 10, 5, 4, 3, 1);
    int index = Collections.binarySearch(list, 3, (o1, o2) -> o2 - o1);
    System.out.println(index);  //4th position
  }

  List<Integer> buildList() {
    return Arrays.asList(0, 2, 3, 5, 7, 11, 20);
  }
}


