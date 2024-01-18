package org.enricogiurin.ocp17.book.ch6;

public class TrickyHidingStaticMethods {

  public static void main(String[] args) {
    new TrickyHidingStaticMethods().call();
  }

  void call() {
    Parent parent = new Child();
    Child child = new Child();
    //here there is not method overriding as methods are static
    parent.message();  //I am the parent
    child.message(); //I am the child
  }

  class Parent {

    public static void message() {
      System.out.println("I am the parent");
    }
  }

  class Child extends Parent {

    public static void message() {
      System.out.println("I am the child");
    }
  }
}

