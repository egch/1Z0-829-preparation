package org.enricogiurin.ocp17.book.ch6.inheritance;

/**
 * With instance variables, there ain't any enforce rule between Parent and Child class
 */
public class InheritanceInstanceVariables {

  class Parent {

    public int y;
    protected int x;
    int z;
  }

  class Child extends Parent {

    private int x;
    private int y;
    private int z;
  }

}
