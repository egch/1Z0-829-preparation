package org.enricogiurin.ocp17.book.ch6.extendprotected.other;

import org.enricogiurin.ocp17.book.ch6.extendprotected.animal.Frog;

public class Tadpole extends Frog {

  public static void main(String[] args) {
    Tadpole t = new Tadpole();
    t.eat();

    // Cannot be accessed from outside package
    //t.jump();
    Frog f = new Tadpole();
    //'eat()' has protected access in 'org.enricogiurin.ocp17.ch6.extendprotected.animal.Frog'

    //here you are in the package other, and you are tyring to access to a method of Frog
    //(the type is Frog, not Tadpole) which is protected, then you cannot!
    //f.eat();

    // Cannot be accessed from outside package
   // f.jump();
  }

}
