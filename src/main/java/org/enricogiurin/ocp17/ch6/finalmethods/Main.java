package org.enricogiurin.ocp17.ch6.finalmethods;

public class Main {

}

class Parent {
  final void hello() {
    System.out.println("hello");
  }

  //also static methods can be marked as final
  //means it cannot be hidden in the child class
  static final void ciao() {
    System.out.println("ciao");
  }

}


class Child extends  Parent {

  //does not compile as the parent method is final
/*  final void hello() {
    System.out.println("hello");
  }*/

  //does not compile as the parent method is final
/*  static final void ciao() {
    System.out.println("ciao");
  }*/

}