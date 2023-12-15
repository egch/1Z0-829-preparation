package org.enricogiurin.ocp17.book.ch2;

public class OperatorPrecedence {

  public static void main(String[] args) {
    OperatorPrecedence op = new OperatorPrecedence();
    op.postIncrementTricky();
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
  void calculateResult() {
    int a = 7;
    int b = 2;
    int c = 4;

    int result = (a + b) * (c % 2) + (++a / b) - (a & b);
    //int result = 9 * 0 + 4 - 0;
    //9*0  3-2 =
    System.out.println(result);
  }

  void postIncrementTricky() {
    int a = 5, b = 7;
    int result = a++/b - a;
    // 5/7 -> 0
    // 5++ -> 6
    // 0 - 6 = -6
    System.out.println(result); //-6

  }

}
