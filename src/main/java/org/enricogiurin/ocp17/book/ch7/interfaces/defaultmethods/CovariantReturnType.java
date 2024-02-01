package org.enricogiurin.ocp17.book.ch7.interfaces.defaultmethods;

public class CovariantReturnType {
  interface Walk {
    default Number getSpeed(){
      return 5;
    }
  }

  interface Run {
    default Long getSpeed(){
      return 10L;
    }
  }

  //this class compiles as Long is a covariant of Number
  class Leopard implements Walk, Run {

    @Override
    public Long getSpeed() {
      return Run.super.getSpeed();
    }
  }


}
