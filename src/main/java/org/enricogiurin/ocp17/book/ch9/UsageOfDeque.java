package org.enricogiurin.ocp17.book.ch9;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.NoSuchElementException;

public class UsageOfDeque {

  public static void main(String[] args) {
    new UsageOfDeque().emptyDeque();
  }

  void methodWithoutException() {
    Deque<String> deck = new LinkedList<>();
    boolean status = deck.offerFirst("1");  //true
    System.out.println(status);
    deck.offerFirst("2");
    deck.offerFirst("3");
    deck.offerLast("4");
    deck.forEach(System.out::println);  //3,2,1,4
    String first = deck.peekFirst();  //equivalent to peek
    System.out.println(first);  //3

    String last = deck.peekLast();
    System.out.println(last);  //4
    String removed = deck.pollFirst(); //[2,1,4]
    System.out.println(removed);  //3
    removed = deck.removeLast();
    System.out.println(removed);  //4

    deck.clear();
    String s = deck.peekFirst();  //even if the deck is empty no exception are thrown
    System.out.println(s);  //null
  }

  void methodWithException() {
    Deque<String> deck = new LinkedList<>();
    deck.addFirst("a");
    deck.removeFirst(); //[]
    //Exception in thread "main" java.util.NoSuchElementException
    deck.removeLast();
  }

  void stack() {

    //stack = LIFO
    Deque<String> stack = new LinkedList<>();
    stack.push("1");  //[1]
    stack.push("2");  //[2,1]
    stack.push("3");  //[3,2,1]
    String peek = stack.peek(); //[3,2,1]
    System.out.println(peek);  //3
    String pop = stack.pop(); //[2,1]
    System.out.println(pop);  //3
    stack.pop(); //[1]
    stack.pop(); //[]
    peek = stack.peek();
    System.out.println(peek);  //null
  }

  void arrayDequeue() {
    //The offer() method inserts an element at the end of the queue
    Deque<String> q = new ArrayDeque<>();
    q.offer("snowball"); // [snowball]
    q.offer("minnie"); // [snowball, minnie]
    q.offer("sugar"); // [snowball, minnie, sugar]
    System.out.print(q.peek() + " " + q.peek() + " " + q.size()); // snowball snowball 3
  }

  void offerAndPush() {
    var deque = new ArrayDeque<>();
    deque.offer(5);
    deque.offer(7);
    deque.push(10); //[10, 5, 7]
    System.out.println(deque.poll() + ", " + deque.poll());  //10, 5
  }

  void peek() {
    Deque<Integer> deque = new ArrayDeque<>();
    deque.addFirst(1);
    deque.addFirst(2);
    deque.addFirst(3);
    System.out.println("peek: " + deque.peek());  //3
    System.out.println("peek: " + deque.peekFirst());  //3
    System.out.println("peek: " + deque.peekLast()); //1
    //now we empty the deque
    deque.clear();
    if (deque.isEmpty()) {
      System.out.println("deque is empty");
    }
    //peek returns null if the deque is empty
    System.out.println("peek: " + deque.peek());  //null
    System.out.println("peek: " + deque.peekFirst());  //null
    System.out.println("peek: " + deque.peekLast()); //null

  }

  void emptyDeque() {
    Deque<Integer> deque = new ArrayDeque<>();
    Integer poll = deque.poll();
    System.out.println("poll: " + poll);
    try {
      //pop triggers a NSE if the deque is empty
      Integer pop = deque.pop();
    } catch (NoSuchElementException nse) {
      //we go here
      nse.printStackTrace();
    }

    try {
      //remove triggers a NSE if the deque is empty
      Integer remove = deque.remove();
    } catch (NoSuchElementException nse) {
      //we go here
      nse.printStackTrace();
    }

  }

}
