package org.enricogiurin.ocp17.ch7.useofenum;

public class Weather {

  public static void main(String[] args) {
    Seasons v = null;
    //When using an enum in a switch expression, the case statement must be made up of the enum values only.
    switch (v) {
      //An enum switch case label must be the unqualified name of an enumeration constant
      //case Seasons.SPRING -> System.out.print("s");

      case SPRING -> System.out.print("s");

      default -> System.out.println("missing data");
    }
  }

  enum Seasons {
    WINTER, SPRING, SUMMER, FALL
  }
}