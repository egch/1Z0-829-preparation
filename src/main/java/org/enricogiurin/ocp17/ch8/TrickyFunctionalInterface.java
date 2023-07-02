package org.enricogiurin.ocp17.ch8;

//If a functional interface includes an abstract method with
//the same signature as a public method found in Object, those methods do not count toward the single abstract method test.
//this is not a FI as toString is defined in Object class
//@FunctionalInterface
interface Soar {
    String toString();
}

public class TrickyFunctionalInterface {
}