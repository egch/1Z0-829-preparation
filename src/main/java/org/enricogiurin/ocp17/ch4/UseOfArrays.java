package org.enricogiurin.ocp17.ch4;

import java.util.Arrays;
import java.util.Date;

public class UseOfArrays {

  public static void main(String[] args) {
    new UseOfArrays().useEquals();
  }

  void callProcess() {
    //not compile
    //process({0,1,2);
    process(new int[]{1, 2, 3});
  }

  void process(int[] array) {
    for (int element : array) {
      System.out.println(element);
    }
  }


  void mismatch() {
    String[] s1 = {"Camel", "Peacock", "Llama"};
    String[] s2 = {"Camel", "Llama", "Peacock"};
    String[] s3 = {"Camel", "Llama", "Peacock"};
    int position = Arrays.mismatch(s1, s2); //first element to differ is at position 1
    //1
    System.out.println(position);
    position = Arrays.mismatch(s2, s3); //they are identical then return -1
    //-1
    System.out.println(position);
  }

  void useEquals(){
    int[] array1 = {1, 3, 5};
    int[] array2 = {1, 3, 5};
    int[] array3 = {1, 5, 5};
    boolean equals = Arrays.equals(array1, array2);
    //true
    System.out.println(equals);
    equals = Arrays.equals(array1, array3);

    //false
    System.out.println(equals);

  }


  void compare() {
    int[] array1 = {1, 3, 5};
    int[] array2 = {1, 3, 5};
    int[] array3 = {1, 5, 5};
    int result = Arrays.compare(array1, array2);
    //0
    System.out.println(result);
    result = Arrays.compare(array1, array3);
    //-1
    System.out.println(result);
  }

  void arrayCreation() {

    //here I specify the size
    int[] array1 = new int[3];

    //here I specify the values
    int[] array2 = new int[]{1,2,3};
    //anonymous array
    int[] array3 = {1,2,3};
    //strange but valid ways to create array
    int array4[] = new int[3];
    int []array5 = new int[3];
    int array6 [] = new int[3];

    //strange array definition
    java.util.Date[] dates[] = new java.util.Date[2][];
    dates[0][0]=new Date();
  }

  void equalsOnArrays() {
    int[] a1 = {1,2,3};
    int[] a2 = {1,2,3};
    //false
    System.out.println(a1.equals(a2));
  }
}
