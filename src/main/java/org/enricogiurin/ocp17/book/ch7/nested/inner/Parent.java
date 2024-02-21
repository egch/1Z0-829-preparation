package org.enricogiurin.ocp17.book.ch7.nested.inner;

public class Parent {

  public void create() {
    var parent = new Parent();
    Child c1 = parent.new Child();

    //create() is an instance method, which means there's an implicit instance of
    // the outer class Parent available.
    Child c2 = new Parent.Child();
  }

  class Child extends Parent {

  }

}
