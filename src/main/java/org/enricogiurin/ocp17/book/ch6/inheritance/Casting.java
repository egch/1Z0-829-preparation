package org.enricogiurin.ocp17.book.ch6.inheritance;

public class Casting {

  void cast() {
    //these are inner classes, but I am in an instance method,
    //means an instance of the class Casting is existing
    Pet p1 = new Pet();
    Dog d1 = new Dog();
    Pet p2 = new Dog();
    //p1 is a pet then won't be cast to Dog
    //but a compile time is fine
    Pet p3 = (Dog) p1;

    // While the cast itself is fine, a Pet cannot be stored in a Dog reference
    //Dog h2 = (Pet) d1; //does not compile
    Pet b4 = (Pet) p2;
    Dog h3 = (Dog) p2;


  }

  class Pet {

  }

  class Dog extends Pet {

  }

}
