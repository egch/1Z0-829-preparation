package org.enricogiurin.ocp17.book.ch8;

@FunctionalInterface
interface Sprint {

  void sprint();
}

@FunctionalInterface
interface Dog extends Sprint {

}

//it is also a FI as it respects the SAM contract - Single Abstract Method
@FunctionalInterface
interface Cat extends Sprint {

  default void miao() {
    System.out.println("miao");
  }
}

//This is not a FI as it defines two abstract methods: sprint()/run()
//@FunctionalInterface
interface Zebra extends Sprint {

  void run();

}

//this cannot be FI as it defines a method with the same signature of Object
/*@FunctionalInterface
interface fakeFI {
  String toString();

}*/

//In spite this defines two abstract methods,
// it is a FI as it inherits the abstract method from Object.
@FunctionalInterface
interface TrickyFI {

  String toString();

  void run();

}

public class UseOfFunctionalInterface {

}
