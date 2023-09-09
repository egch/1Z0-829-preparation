package org.enricogiurin.ocp17.ch7.interfaces;


interface Walk {

  default void go() {
    System.out.println("walk");
  }
}

interface Run {

  default void go() {
    System.out.println("run");
  }
}

//First, if a class or interface inherits two interfaces containing default methods with the same signature,
// it must override the method with its own implementation.
public class ClassInheritTwoDefaultMethods implements Walk, Run {


  //We need this otherwise it won't build
  @Override
  public void go() {
    Run.super.go();
    //or
    Walk.super.go();
  }
}



