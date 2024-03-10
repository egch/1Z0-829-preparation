package org.enricogiurin.ocp17.book.ch7.useofenum;

import java.util.TreeSet;

enum CardinalPoints {
  NORTH, WEST, SOUTH, EAST;  //semicolon is optional for simple enum
}

public class SimpleEnum {

  public static void main(String[] args) {
    //  new SimpleEnum().values();
    new SimpleEnum().switchEnumExpression();

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

  void valuesIsAnArray() {
    CardinalPoints[] values = CardinalPoints.values();
    for (int j = 0; j < values.length; j++) {
      System.out.println(values[j]);
    }
  }

  void valueOf() {
    CardinalPoints north = CardinalPoints.valueOf("NORTH");
    System.out.println(north == CardinalPoints.NORTH);  //true

    try {
      CardinalPoints.valueOf("north");
    } catch (IllegalArgumentException e) {
      //java.lang.IllegalArgumentException: No enum constant org.enricogiurin.ocp17.book.ch7.useofenum.CardinalPoints.north
      e.printStackTrace();
    }
  }

  void comparable() {
    //all enum implements Comparable
    int compare = CardinalPoints.NORTH.compareTo(CardinalPoints.EAST);
    System.out.println(compare);

    //so they can be used in a TreeSet
    TreeSet<CardinalPoints> set = new TreeSet<>();
    set.add(CardinalPoints.SOUTH);
    set.add(CardinalPoints.NORTH);
    set.add(CardinalPoints.WEST);
    System.out.println(set); //[NORTH, WEST, SOUTH]
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

  void switchEnumExpression() {
    var north = CardinalPoints.NORTH;
    char result;
    result = switch (north) {
      case NORTH -> 'n';
      case SOUTH -> 's';
      case EAST -> 'e';
      case WEST -> 'w';
    };
    System.out.println(result);

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
