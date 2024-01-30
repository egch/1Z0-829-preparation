package org.enricogiurin.ocp17.book.ch6.inheritance.privateconstructor;

public class Child extends Parent {

  public Child() {
    //I can't call the parent empty constructor
    //super();  //does not compile!

    //so I have to call the other parent accessible constructor.
    super("I am your child");
    System.out.println("Child constructor");
  }

  //Parent constructor with message: I am your child
  //Child constructor
  public static void main(String[] args) {
    new Child();
  }

}
