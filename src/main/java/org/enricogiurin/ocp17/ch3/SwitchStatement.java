package org.enricogiurin.ocp17.ch3;

public class SwitchStatement {
  void switchStatementWithColon() {
    int x = 2;
    switch (x) {
      //here I use colon to separate the cases
      case 0: case 1:
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


}
