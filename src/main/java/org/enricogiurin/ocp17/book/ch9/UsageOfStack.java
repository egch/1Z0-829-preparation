package org.enricogiurin.ocp17.book.ch9;

import java.util.Stack;

public class UsageOfStack {

  public static void main(String[] args) {
    new UsageOfStack().stack();
  }

  void stack() {
    Stack<String> stack = new Stack<>();
    stack.push("one");
    stack.push("two");
    stack.push("three");
    String pop = stack.pop();
    System.out.println(pop);
    pop = stack.pop();
    System.out.println(pop);
    pop = stack.pop();
    System.out.println(pop);

    System.out.println(stack.isEmpty());

    //Exception in thread "main" java.util.EmptyStackException
    String peek = stack.peek();
    System.out.println(peek);
  }

}
