package org.enricogiurin.ocp17.ch6.abstractclass;

public class Main {

  public static void main(String[] args) {
    //an easy way to avoid class proliferation
    Parent aChild = new Parent() {
      @Override
      void hello() {
        System.out.println("hello");

      }
    };
    aChild.hello();
  }

}

abstract class Parent {

  abstract void hello();

}

class Child extends Parent {

  @Override
  void hello() {
  }
}

abstract class AbstractChild extends Parent {

}
