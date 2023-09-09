package org.enricogiurin.ocp17.ch7.interfaces;

public class UseOfOverride {

}

interface Sport {
  void swim();

  void sleep();

  /*
   *** default methods ***
   */
  default void walk() {
    System.out.println("I'm walking");
  }

  default void run() {
    System.out.println("I'm running");
  }
}

class MySPort implements Sport {


  //@Override is NOT mandatory!
  @Override
  public void swim() {

  }
  //@Override is NOT mandatory! It compiles even without
  //@Override
  public void sleep() {

  }

  /*
   *** default methods ***
   */
  //@Override is NOT mandatory!
  @Override
  public void walk() {
    Sport.super.walk();
  }

  //@Override is NOT mandatory! It compiles even without
  //@Override
  public void run() {
    Sport.super.run();
  }


}
