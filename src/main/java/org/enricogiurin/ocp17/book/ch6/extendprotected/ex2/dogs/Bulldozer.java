package org.enricogiurin.ocp17.book.ch6.extendprotected.ex2.dogs;

import org.enricogiurin.ocp17.book.ch6.extendprotected.ex2.animals.Pet;

public class Bulldozer {

  public void goToEat() {
    Pet pet = new Pet();
    //I cannot access to protected method of Pet as:
    //1) I am not in the same package
    //2) Bulldozer does not extend Pet

    //pet.eat();  //does not compile

    //what abt this?
    Labrador labrador = new Labrador();
    //we are not within Labrador here
    //labrador.pet(); //does not compile
  }

}
