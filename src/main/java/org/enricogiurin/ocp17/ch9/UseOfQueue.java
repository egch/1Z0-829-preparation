package org.enricogiurin.ocp17.ch9;

import java.util.LinkedList;
import java.util.Queue;

public class UseOfQueue {

  public static void main(String[] args) {
    new UseOfQueue().queueException();
  }

  void useQueue() {
    Queue<String> queue = new LinkedList<>();
    queue.add("first");
    queue.add("second");
    queue.add("third");

    String peek = queue.peek();
    System.out.println(peek);  //first
    System.out.println(queue.size());  //3

    String remove = queue.remove();
    System.out.println(remove);  //first
    System.out.println(queue.size()); //2
  }

  void queueException() {
    Queue<String> queue = new LinkedList<>();
    String peek = queue.peek();
    System.out.println(peek);  //null

    //equivalent of peek but throws an exception if empty
    peek = queue.element();

  }

}
