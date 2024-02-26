package org.enricogiurin.ocp17.book.ch9;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.function.UnaryOperator;
import org.enricogiurin.ocp17.various.helper.JarMockTest;

public class MethodsOfList {

  public static void main(String[] args) {
      new MethodsOfList().subList();
  }

  void contains() {
    List<Data> list = List.of(new Data("a"), new Data("b"), new Data("c"));
    boolean contains = list.contains(new Data("c"));
    System.out.println(contains);
  }

  void addRemove() {
    List<String> list = new ArrayList<>();
    list.add("Enrico"); //Enrico
    list.add(0, "John");  //["John", "Enrico']
    //replace the 1st element of the list with Marc
    list.set(1, "Marc");  //["John", "Marc']
    boolean status = list.remove("John"); //["Marc"]
    System.out.println(status ? "removed" : "not found");
    //removed
    //Exception in thread "main" java.lang.IndexOutOfBoundsException: Index 1 out of bounds for length 1
    list.remove(1); //indexOfBoundException
  }

  void replaceAll() {
    List<String> list = new ArrayList<>(List.of("a", "b", "c"));
    UnaryOperator<String> toUpperCase = s -> s.toUpperCase();
    list.replaceAll(toUpperCase);  //["A", "B", "C"]
    list.forEach(System.out::println);
  }

  void convertListToArray() {
    List<String> list = List.of("a", "b", "c");
    //here we convert to an array of Object, we lost information abt the type
    Object[] array = list.toArray();
    //we this we keep our generics
    String[] arrayOfString = list.toArray(new String[0]);
    String[] arrayOfString2 = list.toArray(new String[10]);
    //[size] array: 3 - arrayOfString: 3 - arrayOfString2: 10
    System.out.println(
        "[size] array: %d - arrayOfString: %d - arrayOfString2: %d".formatted(array.length,
            arrayOfString.length, arrayOfString2.length));

  }
  void sort() {
    List<String> list = Arrays.asList("a", "b", "c", "3", "M");
    list.sort(String::compareTo);
    //number, uppercase, lowercase
    System.out.println(list); //[3, M, a, b, c]
  }

  void set() {
    List<String> list = List.of("a", "b", "c");
    List<String> arrayList = new ArrayList<>(list);
    arrayList.set(1, "d");
    System.out.println(arrayList);  //[a, d, c]
  }

  @JarMockTest
  void add(){
    List<String> s1 = new ArrayList<>();
    s1.add("a");
    s1.add("b");
    //insert 'c' between 'a' and 'b'
    s1.add(1, "c");
    System.out.println(s1);  //[a, c, b]
  }

  void subList() {
    List<String> list = Arrays.asList("a", "b", "c", "d");
    //0, 1, (2nd excluded)
    List<String> subList02 = list.subList(0, 2);
    System.out.println(subList02);

    //0 but 0 excluded -> empty
    List<String> emptyList = list.subList(0, 0);
    System.out.println(emptyList);

    try {
      // end is lower than start
      List<String> invalid = list.subList(1, 0);
    } catch (Exception e) {
      //Exception in thread "main" java.lang.IllegalArgumentException: fromIndex(1) > toIndex(0)
      e.printStackTrace();
    }


  }

  //internal data class
  class Data {

    String value;

    public Data(String value) {
      this.value = value;
    }

    @Override
    public int hashCode() {
      return value.hashCode();
    }

    @Override
    public boolean equals(Object o) {
      if (this == o) {
        return true;
      }
      if (o == null || getClass() != o.getClass()) {
        return false;
      }
      Data data = (Data) o;
      return Objects.equals(value, data.value);
    }
  }
}




