package org.enricogiurin.ocp17.book.ch7.interfaces.defaultmethods;

public class CovariantReturnTypePrimitive {

  interface Walk {

    default int getSpeed() {
      return 5;
    }
  }

  interface Run {

    default long getSpeed() {
      return 10L;
    }
  }

  //class Leopard cannot complain no matter how we override getSpeed
  //as long is not a covariant of int.
  /*
  class Leopard implements Walk, Run {  //DOES NOT COMPILE!

    @Override
    public long getSpeed() {
      return 15l;
    }
  }
   */

}
