package org.enricogiurin.ocp17.book.ch9;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.LinkedBlockingQueue;

public class LoopWhileIterating {

  List<Integer> original = List.of(1, 2, 3, 4, 5);

  public static void main(String[] args) {
    new LoopWhileIterating().copyOnWriteArrayListArray();
  }

  /**
   * Exception in thread "main" java.util.ConcurrentModificationException
   */
  void arrayList() {
    var list = new ArrayList<>(original);
    for (int n : list) {
      list.add(n);
    }
  }

  /**
   * CopyOnWriteArrayList makes a copy of the collection every time it is modified, preserving the
   * original list of values the iterator is using.
   */
  void copyOnWriteArrayList() {
    var list = new CopyOnWriteArrayList<>(original);
    for (int n : list) {
      list.add(n);
    }
    //final size is: 10
    System.out.println("final size is: %d".formatted(list.size()));
  }

  void copyOnWriteArrayListArray() {
    Integer[] array = {1, 2, 3, 4};
    CopyOnWriteArrayList<Integer> list = new CopyOnWriteArrayList<>(array);
    for (int n : array) {
      list.add(n);
    }
    for (int n : array) {
      System.out.print(n);
    }
    System.out.println();
    System.out.println(list);
  }

  //this goes in loop
  void linkedBlockingQueue() {
    var queue = new LinkedBlockingQueue<>(original);
    for (int n : queue) {
      queue.add(n);
      //..current size is: 301204
      System.out.println("current size is: %d".formatted(queue.size()));
    }
  }
}
