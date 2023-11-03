package org.enricogiurin.ocp17.book.ch3;

public class StrangeSwitch {

  public static void main(String[] args) {
    new StrangeSwitch().afterDefault();
  }

  void strange() {
    String instrument = "violin";
    final String CELLO = "cello";
    String viole = "viola";
    int p = -1;
    switch (instrument) {
      case "bass":
      case "cane":
        break;
      case CELLO:
        p++;
        //everything after default is executed (if no match are founded)
      default:
        p++;     //p->0
      case "VIOLIN":
        p++;  //p->1
      case "viola":
        ++p;  //p->2
        break;
    }
    System.out.print(p);
  }

  void afterDefault() {
    int x = 5;
    switch (x) {
      case 0:
        System.out.print(0);
      case 1:
        System.out.print(0);
      default:
        System.out.print(100); //100
      case 2:
        System.out.print(0);   //1000
      case 3:
        System.out.print(0);   //10000
      case 4:
        System.out.print(0);   //100000
    }

  }
}
