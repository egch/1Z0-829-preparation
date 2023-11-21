package org.enricogiurin.ocp17.book.ch4.array;

public class ArrayPointers {

  public static void main(String[] args) {
    new ArrayPointers().objectReference();
  }

  void reference() {
    int[][] matrix = new int[10][10];
    matrix[0][0] = 25;
    Object[] reference = matrix;
    int[] array = (int[]) reference[0];
    System.out.println(array[0]);
  }

  void objectArrayReference() {
    Integer[][] array = new Integer[10][10];
    Object[] obj = array;
    //Exception in thread "main" java.lang.ArrayStoreException: java.lang.String
    obj[0] = "hello";
    System.out.println(array[0][0]);


  }

  void objectReference() {
    String s = "hello";
    Object stringReference = s;
    stringReference = Integer.valueOf(5);
  }

}
