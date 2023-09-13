package org.enricogiurin.ocp17.ch8;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public class LambdaWithBlock {

  public static void main(String[] args) {
    new LambdaWithBlock().accessingVariable();
  }

  void block() {
    Function<List<Integer>, Integer> maxArray = list -> {
      int max = Integer.MIN_VALUE;
      for (int n : list) {
        max = Math.max(max, n);
      }
      return max;
    };  //mind the semicolon here
    Integer max = maxArray.apply(List.of(2, 6, 7, 8, 3));
    System.out.println(max);
  }

  void accessingVariable() {
    int key = 4;
    //I cannot modify key as used within the lambda body
    //key = 5;
    Function<Integer[], Integer> binarySearch = array -> {
      //key needs to be final or effective final
      return Arrays.binarySearch(array, key);
    };
    //arrays needs to be sorted!
    Integer[] array = new Integer[]{3, 4, 5, 7, 10};
    Integer position = binarySearch.apply(array);
    System.out.println(position);
  }


}
