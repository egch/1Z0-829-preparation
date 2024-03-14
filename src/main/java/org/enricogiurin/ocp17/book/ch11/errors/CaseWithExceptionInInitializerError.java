package org.enricogiurin.ocp17.book.ch11.errors;

public class CaseWithExceptionInInitializerError {

  static int[] array = new int[0];

  static {
    array[0] = 10;
  }

  //Exception in thread "main" java.lang.ExceptionInInitializerError
  //Caused by: java.lang.ArrayIndexOutOfBoundsException: Index 0 out of bounds for length 0
  public static void main(String[] args) {
    System.out.println("started");
  }

}
