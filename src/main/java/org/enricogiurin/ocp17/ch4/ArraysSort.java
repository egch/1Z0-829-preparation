package org.enricogiurin.ocp17.ch4;

import java.util.Arrays;

public class ArraysSort {

  public static void main(String[] args) {
    new ArraysSort().sortAndSearch();
  }

  void sortAndSearch() {
    int[] array = {2, 6, 3, 1, 9, 8};
    Arrays.sort(array);
    //[1, 2, 3, 6, 8, 9]
    System.out.println(Arrays.toString(array));

    int position = Arrays.binarySearch(array, 2);
    System.out.println(position);
    position = Arrays.binarySearch(array, 5);
    //-5 = -(4) -1
    System.out.println(position);
  }

  void sort() {
    var arr = new String[]{"PIG", "pig", "123"};
    //Numbers sort before letters and uppercase sorts before lowercase.
    Arrays.sort(arr);  //"123", "PIG", "pig"
    int position = Arrays.binarySearch(arr, "Pippa");

    //result : -insertionPoint -1
    //insertionPoint ideally would be 2 (after "PIG")
    //-> result = -2 -1 = -3
    System.out.println(position);  //-3
  }


}
