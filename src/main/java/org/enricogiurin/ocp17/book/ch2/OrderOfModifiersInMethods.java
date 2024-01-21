package org.enricogiurin.ocp17.book.ch2;

public class OrderOfModifiersInMethods {

  public static void m3() {
  }
  //invalid
  // void public  2(){}

  //still valid
  static public void m4() {
  }

  public void m1() {
  }

}
