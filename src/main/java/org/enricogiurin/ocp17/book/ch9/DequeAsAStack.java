package org.enricogiurin.ocp17.book.ch9;

import java.util.Deque;
import java.util.LinkedList;

public class DequeAsAStack {

  public static void main(String[] args) {
    new DequeAsAStack().popVsPoll();
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

  void popVsPoll() {
    Deque<String> stack = new LinkedList<>();
    String result = stack.poll();  //this returns null
    System.out.println(result); //null
    stack.getFirst();
    //Exception in thread "main" java.util.NoSuchElementException
    String pop = stack.pop();
  }

}
