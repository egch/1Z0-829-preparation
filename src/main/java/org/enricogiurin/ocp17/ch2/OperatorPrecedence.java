package org.enricogiurin.ocp17.ch2;

public class OperatorPrecedence {

  public static void main(String[] args) {
    OperatorPrecedence op = new OperatorPrecedence();

    op.complex();
  }

  void relational() {
    //operator + is evaluated before operator <
    if (value(3) + value(2) < value(6)) {
      System.out.println("condition is true");
    }
  }

  void logicalOperator() {
    if (2 + 3 < 5 && 2 > 1) {
      System.out.println("condition is true");
    }
  }


  void complex() {
    if (2 + 3 <= 5 && 4 + 5 >= 9 || 2 < 3) {
      System.out.println("condition is true");
    }
  }

  private int value(int x) {
    System.out.println("value: " + x);
    return x;
  }

}
