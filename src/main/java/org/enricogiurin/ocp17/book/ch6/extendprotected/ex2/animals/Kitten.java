package org.enricogiurin.ocp17.book.ch6.extendprotected.ex2.animals;

public class Kitten extends Pet {

  public void goToEat() {
    //protected access on Pet: same package & extend class
    eat();
    System.out.println("I have eaten");
  }


}
