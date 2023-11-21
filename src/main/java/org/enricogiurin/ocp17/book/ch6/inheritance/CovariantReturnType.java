package org.enricogiurin.ocp17.book.ch6.inheritance;

interface Run {

  Number getSpeed();
}

public class CovariantReturnType {

  public static void main(String[] args) {
    new Jaguar().getSpeed();
  }


}

abstract class Feline {

  abstract Long getSpeed();
}

//mind the order!
//extends comes before implements
class Jaguar extends Feline implements Run {
  //this does not compile as Integer is not a subclass of Long
/*  @Override
  public Integer getSpeed() {
    return 0;
  }*/

  //this does compile as Long is a covariant of Number
  @Override
  public Long getSpeed() {
    return 100L;
  }
}

