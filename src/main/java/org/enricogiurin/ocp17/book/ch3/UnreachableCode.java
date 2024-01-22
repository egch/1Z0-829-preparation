package org.enricogiurin.ocp17.book.ch3;

public class UnreachableCode {

  void unreachable() {
    while (2 < 3) {
      System.out.println("looping");
    }
    //Unreachable statement
    //System.out.println("end");  /does not compile
  }

  void trickUnreachable() {
    int a = 2, b = 3;
    while (a < b) {
      System.out.println("still looping");
    }
    //this compiles in spite it is effectively similar to the other method
    System.out.println("I am done");
  }

}
