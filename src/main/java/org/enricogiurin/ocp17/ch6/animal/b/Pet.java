package org.enricogiurin.ocp17.ch6.animal.b;

import org.enricogiurin.ocp17.ch6.animal.a.Animal;

public class Pet extends Animal {


  public static void main(String[] args) {
    Animal p = new Pet();
    //p cannot access to weight //protected
    //p cannot access to height //different package

    Pet p2 = new Pet();
    p2.weight(4);
    //p2 cannot access to height as it's in a different package
    //p2.height(5)

  }

}
