package org.enricogiurin.ocp17.book.ch13;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class UseOfCopyOnWriteArrayList {

  public static void main(String[] args) {
    //    new UseOfCopyOnWriteArrayList().addDuringIteration();
    new UseOfCopyOnWriteArrayList().addDuringIteration();
  }

  void addDuringIteration() {
    List<Integer> list = new CopyOnWriteArrayList<>(List.of(1, 3, 5));
    //size is: 3
    System.out.println("size is: " + list.size());
    //the iterator is not changed
    for (int value : list) {
      list.add(value + 2);
    }
    //size is: 6
    System.out.println("size is: " + list.size());
  }

  void addDuringIterationNotConcurrent() {
    List<Integer> list = new ArrayList<>(List.of(4, 3, 42));
    //size is: 3
    System.out.println("size is: " + list.size());
    //Exception in thread "main" java.util.ConcurrentModificationException
    for (int value : list) {
      list.add(value + 2);
    }

  }
}
