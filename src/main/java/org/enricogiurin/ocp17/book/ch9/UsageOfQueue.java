package org.enricogiurin.ocp17.book.ch9;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

public class UsageOfQueue {

  public static void main(String[] args) {
    new UsageOfQueue().useQueueNotThrowingException();
  }

  void useQueue() {
    //here we use add(), element(), remove()
    //all these elements throws exception (RTE) if something goes wrong
    Queue<String> queue = new LinkedList<>();
    queue.add("first");
    queue.add("second"); //[first, second]
    queue.add("third"); //[first, second, third]
    System.out.println(queue);

    String element = queue.element();
    System.out.println(element);  //first
    System.out.println(queue.size());  //3

    String remove = queue.remove();
    System.out.println(remove);  //first
    System.out.println(queue.size()); //2
  }

  void useQueueNotThrowingException() {
    //here we use add(), element(), remove()
    //all these elements throws exception (RTE) if something goes wrong
    Queue<String> queue = new ArrayDeque<>();
    queue.offer("first");
    queue.offer("second"); //[first, second]
    queue.offer("third"); //[first, second, third]
    System.out.println(queue);

    String element = queue.peek();
    System.out.println(element);  //first
    System.out.println(queue.size());  //3

    String remove = queue.poll();
    remove = queue.poll();
    remove = queue.poll(); //[]
    remove = queue.poll(); //[]

    System.out.println(remove);  //null

  }

  void queueException() {
    Queue<String> queue = new LinkedList<>();
    //peek() does not throw RTE if there ain't element, it just returns null
    String peek = queue.peek();
    System.out.println(peek);  //null

    //equivalent of peek but throws an exception if empty
    try {
      //java.util.NoSuchElementException
      peek = queue.element();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  void methodsOfQueue() {
    Queue<String> queue = new ArrayDeque<>();
    queue.add("John");
    //there ain't method such as addLast as it's not a double-ended queue
    //queue.addLast("Doe");  //does not compile!
  }

  void poll() {
    Queue<String> queue = new ArrayDeque<>();
    String poll = queue.poll();
  }

}
