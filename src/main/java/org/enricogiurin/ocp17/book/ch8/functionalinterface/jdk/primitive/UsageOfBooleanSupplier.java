package org.enricogiurin.ocp17.book.ch8.functionalinterface.jdk.primitive;

import java.time.LocalDate;
import java.util.function.BooleanSupplier;

public class UsageOfBooleanSupplier {

  public static void main(String[] args) {
    new UsageOfBooleanSupplier().anonymous();
  }

  void usage() {
    //note: there ain't generics here!
    BooleanSupplier bs = () -> Math.random() > 0.5;
    //NOTE: it is getAsBoolean() NOT get()
    boolean result = bs.getAsBoolean();
    System.out.println(result);  //can be true or false
  }

  void anonymous() {
    BooleanSupplier isDayEven = new BooleanSupplier() {
      //note that it returns a primitive boolean!
      @Override
      public boolean getAsBoolean() {
        return LocalDate.now().getDayOfMonth() % 2 == 0;
      }
    };//mind the semicolon!
    System.out.println(isDayEven.getAsBoolean()); //false on 19/1/24
  }


}
