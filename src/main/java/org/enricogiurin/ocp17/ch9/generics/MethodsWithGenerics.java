package org.enricogiurin.ocp17.ch9.generics;

public class MethodsWithGenerics {

  public static <T> T getFirstElement(T[] array) {
    if (array != null && array.length > 0) {
      return array[0];
    } else {
      return null;
    }
  }

  public static void main(String[] args) {
    Integer[] intArray = {1, 2, 3, 4, 5};
    String[] stringArray = {"Hello", "World"};

    Integer firstInt = getFirstElement(intArray);
    String firstString = getFirstElement(stringArray);

    System.out.println("First Integer: " + firstInt);
    System.out.println("First String: " + firstString);
  }


}
