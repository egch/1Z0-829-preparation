package org.enricogiurin.ocp17.book.ch7.nested.local;

import java.util.Arrays;

//code concept from chat gpt, then slightly adapted
public class ArraySorter {

  private int[] numbers;

  public ArraySorter(int[] numbers) {
    this.numbers = numbers;
  }

  public static void main(String[] args) {
    int[] numbers = {5, 2, 9, 1, 5, 6};
    ArraySorter sorter = new ArraySorter(numbers);

    // Call the instance method to sort the array
    sorter.sortArray();

    // Print the sorted array
    for (int num : numbers) {
      System.out.print(num + " ");
    }
  }

  public void sortArray() {
    int size = ArraySorter.this.numbers.length;

    // Local class for sorting the array
    //scope within the method
    class CustomSorter {

      public void sort() {
        //how to access to the fields in the outer class
        Arrays.sort(ArraySorter.this.numbers);
        //variable 'size' is accessed from within inner class, needs to be final or effectively final
        //System.out.println(size);  //does not compile!
      }
    }

    CustomSorter sorter = new CustomSorter();
    sorter.sort();
    //here I modify size, so I make it not effectively final
    size = 0;


  }
}
