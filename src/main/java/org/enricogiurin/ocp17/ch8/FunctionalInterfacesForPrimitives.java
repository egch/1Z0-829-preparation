package org.enricogiurin.ocp17.ch8;

import java.util.Random;
import java.util.function.BooleanSupplier;
import java.util.function.DoublePredicate;
import java.util.function.DoubleSupplier;

public class FunctionalInterfacesForPrimitives {

  public static void main(String[] args) {
    new FunctionalInterfacesForPrimitives().doublePredicate();
  }

  void booleanSupplier() {
    BooleanSupplier bs = ()-> Math.random() >= 0.5;
    for (int j = 0; j < 10; j++) {
      System.out.println(bs.getAsBoolean());
    }
  }

  void doubleSupplier() {
    DoubleSupplier ds = () -> new Random().nextDouble();
    System.out.println(ds.getAsDouble());
  }

  void doublePredicate() {
    DoublePredicate dp = d-> d % 2 == 0;
    System.out.println(dp.test(5.2D)); //false
    System.out.println(dp.test(6.0D)); //true
  }

}
