package org.enricogiurin.ocp17.book.ch9.generics;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;


//note: this class has no generics defined in the class itself
public class MethodsWithGenerics {

  public static void main(String[] args) {
    new MethodsWithGenerics().callAddElementToCollection();
  }

  //created by ChatGPT
  //method can be both instance or static
  public static <T extends Comparable<T>> T findMin(T[] array) {
    if (array == null || array.length == 0) {
      throw new IllegalArgumentException("Array is null or empty.");
    }
    T min = array[0];

    for (T element : array) {
      if (element.compareTo(min) < 0) {
        min = element;
      }
    }
    return min;
  }

  //method can be both instance or static
  public <T> T getFirstElement(T[] array) {
    if (array != null && array.length > 0) {
      return array[0];
    } else {
      return null;
    }
  }

  <T extends Collection<U>, U extends CharSequence> U addElementToCollection(T list, U element) {
    list.add(element);
    return element;
  }

  void callAddElementToCollection() {
    ArrayList<String> list = new ArrayList<>();
    String enrico = addElementToCollection(list, "Enrico");
    //optional syntax for generics
    this.<List<String>, String>addElementToCollection(null, "a");
    System.out.println("size: " + list.size());

    var integers = new ArrayList<Integer>();
    //does not compile
    // addElementToCollection(integers, 5);
  }

  void callGetFirstElement() {
    Integer[] intArray = {1, 2, 3, 4, 5};
    String[] stringArray = {"Hello", "World", "2", "ciao"};

    Integer firstInt = getFirstElement(intArray);
    String firstString = getFirstElement(stringArray);

    System.out.println("First Integer: " + firstInt);
    System.out.println("First String: " + firstString);
  }

  void callFindMin() {
    Integer[] intArray = {1, 2, 3, 4, 5};
    String[] stringArray = {"Hello", "World", "2", "ciao"};
    StringBuilder[] stringBuilders = {new StringBuilder("a"), new StringBuilder("b")};
    Set<Integer>[] setArray = new Set[]{Set.of(1), Set.of(2)};

    Integer minInteger = findMin(intArray);
    String minString = findMin(stringArray);
    StringBuilder minStringBuilder = findMin(stringBuilders);
    //reason: no instance(s) of type variable(s) T exist so that Set<Integer> conforms to Comparable<T>
    // T min = findMin(setArray);  does not compile, as Set do not implement Comparable

    System.out.println("min of Integer: " + minInteger);
    System.out.println("min of String: " + minString);
    System.out.println("min of StringBuilder: " + minStringBuilder);
  }


}
