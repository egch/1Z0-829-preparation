package org.enricogiurin.ocp17.book.ch4.array;

public class ArrayType {

  public static void main(String[] args) {
    new ArrayType().multiDArray();
  }

  void multiDArray() {
    Parent[] parents = new Parent[2];
    parents[0] = new Parent();
    Child[] children = new Child[4];
    parents = children;
    //not feasible
    // children = parents;  //does not compile
    children = (Child[]) parents;
  }

  class Parent {

  }

  class Child extends Parent {

  }
}
