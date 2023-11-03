package org.enricogiurin.ocp17.book.ch3;

public class SwitchType {

  void switchLong() {
    long aLong = 5L;
    //long not supported
/*    switch (aLong){
      case 1L:
        System.out.println(1);

    }*/
  }

  void switchParameter(final int x) {
    int y = 4;
    switch (y) {
      //xis not a compile-time constant since any int value can be passed as a parameter.
      // Marking it final does not change this, so it doesn’t compile.
/*      case x:
        System.out.println("x is: "+x);*/
      default:
        System.out.println("default");
    }
  }

}
