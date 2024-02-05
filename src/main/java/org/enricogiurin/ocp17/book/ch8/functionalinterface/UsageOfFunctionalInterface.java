package org.enricogiurin.ocp17.book.ch8.functionalinterface;

public class UsageOfFunctionalInterface {


  /**
   * this cannot be FI as it defines a method with the same signature of Object
   */
//@FunctionalInterface
  interface fakeFI {

    String toString();
  }

  /**
   * In spite this defines two abstract methods, it is a FI as it inherits the abstract method from
   * Object.
   */
  @FunctionalInterface
  interface TrickyFI {

    String toString();

    void run();
  }

  @FunctionalInterface
  interface Sprint {

    void sprint();
  }

  /**
   * This is also a FI as it respects the SAM contract - Single Abstract Method
   */
  @FunctionalInterface
  interface Cat extends Sprint {

    default void meow() {
      System.out.println("meow");
    }
  }

  /**
   * This is not a FI as it defines two abstract methods: sprint()/run()
   */
  //
//@FunctionalInterface
  interface Zebra extends Sprint {

    void run();
  }

  /**
   * This is a FI as it respects the SAM contract - Single Abstract Method
   */
  @FunctionalInterface
  interface Dog extends Sprint {

  }

}
