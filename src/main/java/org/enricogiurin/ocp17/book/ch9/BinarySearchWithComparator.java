package org.enricogiurin.ocp17.book.ch9;

import java.util.Arrays;
import java.util.Comparator;

public class BinarySearchWithComparator {

  public static void main(String[] args) {
    new BinarySearchWithComparator().callSortAndSearch();
  }

  void callSortAndSearch() {
    Comparator<String> cReverse = (x, y)-> -y.compareTo(x);
    sortAndSearch(cReverse, "seed", "flower");
  }

  private void sortAndSearch(Comparator<String> comparator, String... args) {
    var one = args[1];

    Arrays.sort(args, comparator);
    var result = Arrays.binarySearch(args, one, comparator);
    System.out.println(result);
  }


}
