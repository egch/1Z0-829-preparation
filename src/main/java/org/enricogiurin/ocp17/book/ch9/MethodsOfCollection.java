package org.enricogiurin.ocp17.book.ch9;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class MethodsOfCollection {

  public static void main(String[] args) {
    new MethodsOfCollection().removeIfWithSet();
  }

  void replaceAll() {
    List<String> list = new ArrayList<>();
    list.add("aa");
    list.add("ab");
    list.add("bc");

    list.replaceAll(s -> s + "xxx");
    list.forEach(System.out::println);
  }

  void remove() {
    List<Integer> list = new ArrayList<>();
    list.add(3);
    list.add(2);
    list.add(1);
    list.remove(2); //remove element at index 2 ->[3,2]
    list.forEach(System.out::println);  //3,2
    list.remove(
        Integer.valueOf(2));  //remove the element 2, as here I am calling the method remove(T)
    System.out.println();
    list.forEach(System.out::println);  //3
  }

  void addRemove() {
    List<String> list = new ArrayList<>(List.of("a", "b", "c"));
    boolean status = list.add("d");
    System.out.println(status);
    String element = list.remove(0);
    System.out.println(element); //a
    //this time is boolean
    status = list.remove("a");
    System.out.println(status); //false

    status = list.remove("c");
    System.out.println(status); //true
  }

  void clear() {
    List<String> list = new ArrayList<>(List.of("a", "b", "c"));
    System.out.println("size is: " + list.size());  //3
    System.out.println("is empty? " + list.isEmpty());  //false
    list.clear();
    System.out.println("size is: " + list.size());  //0
    System.out.println("is empty? " + list.isEmpty()); //true
  }

  void contains() {
    List<String> list = new ArrayList<>(List.of("a", "b", "c"));
    boolean contains = list.contains("b");
    System.out.println(contains); //true
    //type of contains is Object
    contains = list.contains(1);
    System.out.println(contains); //false
  }

  void removeIf() {
    List<String> list = new ArrayList<>(List.of("ab", "bb", "cb"));
    System.out.println("size is: " + list.size());  //3
    //passing a lambda
    boolean status = list.removeIf(s -> s.startsWith("a"));
    System.out.println(status);
    System.out.println("size is: " + list.size());  //3
  }

  void removeIfWithSet() {
    Set<String> set = new HashSet<>();
    set.add("hello");
    set.removeIf(s -> s.startsWith("h"));
    System.out.println(set.size());
  }

  void iterator() {
    List<String> list = new ArrayList<>(List.of("ab", "bb", "cb"));
    for (String s : list) {
      System.out.println(s);
    }
    //alternative approach
    list.forEach(s -> System.out.println(s)); //lambda
    list.forEach(System.out::println); //method reference
  }

  void oldIterator() {
    List<String> list = new ArrayList<>(List.of("1", "2", "3"));
    //old school iterator
    Iterator<String> iterator = list.iterator();
    while (iterator.hasNext()) {
      System.out.println(iterator.next());
    }
  }

  void checkEquals() {
    List<String> listA = List.of("1", "2", "3");
    List<String> listB = List.of("1", "2", "3");
    System.out.println(listA.equals(listB));  //true
    List<String> listC = List.of("3", "2", "1"); //order matters
    System.out.println(listA.equals(listC)); //false

    //set
    Set<String> setA = Set.of("1", "3", "2");  //order does not matter
    Set<String> setB = Set.of("3", "1", "2");
    System.out.println(setA.equals(setB)); //true

  }
}
