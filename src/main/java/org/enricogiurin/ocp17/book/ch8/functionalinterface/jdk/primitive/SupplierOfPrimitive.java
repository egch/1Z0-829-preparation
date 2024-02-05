package org.enricogiurin.ocp17.book.ch8.functionalinterface.jdk.primitive;

import java.util.Random;
import java.util.function.BooleanSupplier;
import java.util.function.DoubleSupplier;
import java.util.function.IntSupplier;
import java.util.function.LongSupplier;

public class SupplierOfPrimitive {

  void booleanSupplier() {
    BooleanSupplier bs = () -> Math.random() >= 0.5;
    for (int j = 0; j < 10; j++) {
      //note that it's getAsBoolean() NOT get()
      System.out.println(bs.getAsBoolean());
    }
  }

  void doubleSupplier() {
    DoubleSupplier ds = () -> new Random().nextDouble();
    //mind the method: getAsDouble()!
    double asDouble = ds.getAsDouble();
    System.out.println(asDouble);
  }

  void longSupplier() {
    LongSupplier longSupplier = () -> 10L;
    long asLong = longSupplier.getAsLong();
    System.out.println(asLong);
  }

  void intSupplier() {
    IntSupplier intSupplier = () -> new Random().nextInt(100);
    int asInt = intSupplier.getAsInt();
    System.out.println(asInt);
  }

}
