package org.enricogiurin.ocp17.book.ch3.usageofswitch;

import org.enricogiurin.ocp17.various.helper.JarMockTest;

public class SwitchStatement {

  public static void main(String[] args) {
    new SwitchStatement().switchMissingCase();
  }

  void switchStatementWithColon() {
    int x = 2;
    switch (x) {
      //here I use colon to separate the cases
      case 0:
      case 1:
        System.out.println("0 or 1");
        break;
      default:
        System.out.println("default");
    }
  }

  void switchStatementWithComma() {
    int x = 2;
    switch (x) {
      //here I use comma to separate the cases
      case 0, 1:
        System.out.println("0 or 1");
        break;
      default:
        System.out.println("default");
    }
  }

  void mixedDefault() {
    //default case can be put in any place
    int x = 0;
    //all it's printed:
    //0
    //default
    //5
    switch (x){
      case 0: System.out.println(0);
      default:
        System.out.println("default");
      case 5:
        System.out.println("5");
    }
  }

  void switchWithNoConstant() {
    int x = 0;
    int result = 0;
    int aValue = 5;
    final int aConstant = 6;
    switch (x) {
      case 2:
        result++;
        break;
      default:
        result = -1;
        break;
      //not allowed, it's not final
      //case aValue:
      case aConstant:
        result = 3;
        break;
    }
    System.out.println(result);
  }

  @JarMockTest
  //it prints default
  //There is no case for THURSDAY and MONDAY, so they are just labels!!
  void switchMissingCase() {
    var day = DayOfWeek.MONDAY;
    switch (day){
      case TUESDAY:
      THURSDAY:
      MONDAY:
        System.out.println("MONDAY");  //it won't be printed!
      default:
        System.out.println("default");  //it prints default
    }
  }
}
