package org.enricogiurin.ocp17.book.ch6.extendprotected.ex2.dogs;

import org.enricogiurin.ocp17.book.ch6.extendprotected.ex2.animals.Pet;

public class Labrador extends Pet {

  public static void main(String[] args) {
    Labrador labrador = new Labrador();
    //I can access because eat is protected and Labrador is a subclass of Pet
    labrador.eat();

    //here the reference is Pet
    Pet jimmy = new Labrador();
    //I can't access because Pet is neither a subclass of Pet (itself) nor in the same package
    //jimmy.eat();  //does not compile!
  }

  public void goToEat() {
    //I can access because eat is protected and Labrador is a subclass of Pet
    eat();
  }

}
