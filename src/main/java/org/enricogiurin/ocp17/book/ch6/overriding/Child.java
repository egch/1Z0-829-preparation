package org.enricogiurin.ocp17.book.ch6.overriding;

/*
    *********************************************************
    ************** MEMORIZE THIS!!!!  ***********************
    *********************************************************
 */

abstract class Parent {
  public abstract void printDetails();

  public int getWeight() {
    return weight;
  }

  public int getHeight() {
    return height;
  }

  int weight = 5;
  int height = 7;

}
public class Child extends Parent {
  //this weight, and eight have nothing to do with those defined in the Parent class
  private int weight = 10;
  private int height = 14;

  //Polymorphism and overriding do not apply to instance variables.
  public void printDetails() {
    System.out.println(super.getWeight() + ", " + this.height);
  }

  public static void main(String[] args) {
    var child = new Child();
    child.printDetails();  //5, 14
    System.out.println(child.weight+", "+child.height);  //10, 14

    Parent parent = new Child();
    parent.printDetails();  //5, 14
    System.out.println(parent.weight+", "+parent.height);  //5, 7
  }
}


