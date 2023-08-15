package org.enricogiurin.ocp17.ch6;

public class DefaultConstructor {

  public static void main(String[] args) {
    //GrandChild nephew = new GrandChild();
    GrandChild nephewWithName = new GrandChild("enrico");
    //output:
//        I am the parent
//        I am the child
//        I am the grandChild: enrico
  }

}


class Parent {

  public Parent() {
    System.out.println("I am the parent");
  }
}

class Child extends Parent {

  public Child() {
    System.out.println("I am the child");
  }

}

class GrandChild extends Child {

  public GrandChild() {
    System.out.println("I am the grandChild");
  }

  public GrandChild(String name) {
    System.out.println("I am the grandChild: " + name);
  }

}

