package org.enricogiurin.ocp17.book.ch9;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CreatingListWithFactory {

  public static void main(String[] args) {
    new CreatingListWithFactory().of();
  }

  void create() {
    String[] array = {"a", "b", "c"};
    //this list is not immutable but I can't add/delete elements
    List<String> arrayList = Arrays.asList(array);
    //this list is immutable!!
    List<String> listOf = List.of(array);
    //we change the first element of the array
    array[0] = "k";
    //arrayList is affected!!!!
    System.out.println(arrayList);  // [k, b, c]
    System.out.println(listOf);    // [a, b, c]
  }

  void of() {
    var v = List.of("mouse", "parrot");
    v.removeIf(String::isEmpty);
    v.removeIf(s -> s.length() == 4);
  }

  void sortAnImmutableList() {
    List<Integer> list = List.of(5, 3, 1);

    //I cannot sort an immutable collection!
    //Exception in thread "main" java.lang.UnsupportedOperationException
    //	at java.base/java.util.ImmutableCollections.uoe(ImmutableCollections.java:142)
    Collections.sort(list);
    Integer result = list.get(0);
    System.out.println(result);
  }

  void copyOf() {
    //sourceList is immutable
    List<Integer> sourceList = List.of(1, 2, 3);  //accepts vararg
    //cloneList is immutable
    List<Integer> cloneList = List.copyOf(sourceList); //accepts collection
    //cloneList is immutable
    cloneList.add(2);  //exception at runtime
  }

}
