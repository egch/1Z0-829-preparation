package org.enricogiurin.ocp17.book.ch9.generics;

/**
 * A few examples of classes, not collections lower and upper bounded.
 */
public class ClassesWithWildcards {

  class Cage<T extends Pet> {}

  class Pet {}
  class Dog extends Pet{}

  void leftAssignment() {

    Cage<Dog> cageDogs = new Cage<Dog>();
    //requires Pet, not Dog
    //Cage<Pet> cagePets = new Cage<Dog>();  //DOES Not Compile

    //upper-bounded cases
    Cage<? extends Pet> upperBounded = new Cage<Pet>();
    Cage<? extends Pet> upperBounded2 = new Cage<Dog>();

    //lower-bounded cases
    //Dog is a subclass of Pet
    //Cage<? super Pet> lowerBounded1 = new Cage<Dog>(); //  //DOES Not Compile
    Cage<? super Pet> lowerBounded2 = new Cage<Pet>(); //
  }


}
