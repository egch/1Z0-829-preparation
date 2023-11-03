package org.enricogiurin.ocp17.book.ch9;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.UnaryOperator;

public class MethodsOfList {

  public static void main(String[] args) {
    new MethodsOfList().convertListToArray();
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

    //the size is the original size of the list
    System.out.println("size is " + arrayOfString.length);  //size is 3
    //here we have 10 as passed in the argument
    System.out.println("size is " + arrayOfString2.length);  //size is 10


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
