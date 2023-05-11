package org.enricogiurin.ocp17.crashcourse.sealedtypes;

// IF, but only if, all types in this sealed type hierarchy
// are in the same source file, then permits may be omitted.
// I believe the intention is to simplify development
//sealed interface Transporter /*permits Truck, Car, Bicycle*/ {
// If running (but also compiler observes this) under Module System
// (JPMS) elements of the hierarchy can be in the same module but
// different packages. IF NOT under JPMS, all elements in the hierarchy
// MUST BE IN THE SAME PACKAGE
sealed interface Transporter permits Truck, Car, Bicycle {
}

sealed class Truck implements Transporter permits BoxVan {
}

// lose control of children here
non-sealed class BoxVan extends Truck {}

final class Car implements Transporter {
}

// records are implicitly final!
// enums are not "final" but they control their child types
// if any exist, they must be anonymous/nested types
// records can implement interfaces, but cannot extend anything explicit
record Bicycle() implements Transporter {}

public class Ex1 {
  public static void main(String[] args) {
    Transporter t = Math.random() > 0.5 ? new Truck() : new Car();

    if (t instanceof Truck tr) {
      // can the truck do this?
    } else if (t instanceof Car c) {
      // can the car do this?
    }

  }
}
