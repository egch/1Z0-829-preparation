package org.enricogiurin.ocp17.book.ch7.useofenum;

enum CardinalPoints {
  NORTH, WEST, SOUTH, EAST;  //semicolon is optional for simple enum
}

public class SimpleEnum {

  public static void main(String[] args) {
    //  new SimpleEnum().values();
    new SimpleEnum().switchEnum();

  }

  /*
  NORTH - 0
  WEST - 1
  SOUTH - 2
  EAST - 3
   */
  void values() {
    for (CardinalPoints cp : CardinalPoints.values()) {
      System.out.println(cp.name() + " - " + cp.ordinal());
    }
  }

  void switchEnum() {
    CardinalPoints cp = CardinalPoints.NORTH;
    switch (cp) {
      case NORTH:
        System.out.println("north");
        break;

      //does not compile-> refer without qualifier
        /*
        case CardinalPoints.EAST:
        System.out.println("east");
        break;
        */

      default:
        System.out.println("not north");
    }
  }

  void assignEnum() {
    CardinalPoints north = CardinalPoints.NORTH;
    System.out.println(north);
  }

}

//I cannot extend an enum!
/*
enum ExtendedCP extends CardinalPoints {}  //does not compile!
*/
