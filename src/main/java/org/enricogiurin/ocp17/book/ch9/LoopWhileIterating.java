package org.enricogiurin.ocp17.book.ch9;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.LinkedBlockingQueue;

public class LoopWhileIterating {

  public static void main(String[] args) {
    new LoopWhileIterating().linkedBlockingQueue();
  }
  List<Integer> original = List.of(1,2,3,4,5);

  /**
   * Exception in thread "main" java.util.ConcurrentModificationException
   */
  void arrayList(){
    var list = new ArrayList<>(original);
    for(int n:list){
      list.add(n);
    }
  }

  /**
   * CopyOnWriteArrayList makes a copy of the collection every time it is modified,
   * preserving the original list of values the iterator is using.
   */
  void copyOnWriteArrayList(){
    var list = new CopyOnWriteArrayList<>(original);
    for(int n:list){
      list.add(n);
    }
    //final size is: 10
    System.out.println("final size is: %d".formatted(list.size()));
  }

  //this goes in loop
  void linkedBlockingQueue() {
    var queue = new LinkedBlockingQueue<>(original);
    for(int n:queue){
      queue.add(n);
      //..current size is: 301204
      System.out.println("current size is: %d".formatted(queue.size()));
    }
  }
}
