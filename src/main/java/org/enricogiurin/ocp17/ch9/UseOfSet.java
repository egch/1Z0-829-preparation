package org.enricogiurin.ocp17.ch9;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class UseOfSet {

  public static void main(String[] args) {
    new UseOfSet().treeSet();
  }

  void create() {
    Set<String> setA = new HashSet<>();
    Set<String> setB = Set.of("a", "b");
    //mutable set
    Set<String> setC = new HashSet<>(setB);
    Set<String> tressSet = new TreeSet<>();
  }

  void treeSet() {
    TreeSet<Integer> set = new TreeSet<>();
    set.add(5);
    set.add(2);
    set.add(10);
    set.add(10);
    set.forEach(System.out::println);  //2, 5, 10
  }

}
