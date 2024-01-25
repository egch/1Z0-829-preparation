package org.enricogiurin.ocp17.book.ch6.extendprotected.ex2.animals;

public class Bunny {
  public void goToEat() {
    Pet pet = new Pet();
    //protected access on Pet (same package)
    pet.eat();
    System.out.println("I have eaten");
  }

}
