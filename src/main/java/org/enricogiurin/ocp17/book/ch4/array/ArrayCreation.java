package org.enricogiurin.ocp17.book.ch4.array;

import java.util.Date;

public class ArrayCreation {

  void creation() {
    int[] a1 = new int[10];
    int[] a2 = new int[]{1, 2, 3};
    int[] a3 = {1, 2, 3};

    //weird but allowed
    int a4[] = new int[10];

    //very weird but allowed
    int a5[] = new int[]{};
  }

  void tricky() {
    int[] a1;
    //Array initializer is not allowed here
    //a1 = {1,2,3};

    a1 = new int[]{1, 2, 3};

    //does not compile because the brackets are before the type
    //[]int wrong = new int[10]; //does not compile
  }

  void array2D() {
    int[][] m1 = new int[3][3];
    int[][] m2 = new int[][]{{1, 2, 3},
        {1, 3, 5}};
    //weird but allowed
    int[] m3[] = new int[3][3];

    int m4[][] = new int[3][3];
  }

  void arrayWithVar() {
    var myArray = new int[3];  //valid
    //var wrong[] = new int[3];  //does not compile
  }


  void arrayCreation() {

    //here I specify the size
    int[] array1 = new int[3];

    //here I specify the values
    int[] array2 = new int[]{1, 2, 3};
    //anonymous array
    int[] array3 = {1, 2, 3};
    //strange but valid ways to create array
    int array4[] = new int[3];
    int[] array5 = new int[3];
    int array6[] = new int[3];

    //strange array definition
    java.util.Date[] dates[] = new java.util.Date[2][];
    dates[0][0] = new Date();
  }

}
