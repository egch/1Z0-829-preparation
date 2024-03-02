package org.enricogiurin.ocp17.book.ch2;

public class OperatorPrecedence {

  public static void main(String[] args) {
    OperatorPrecedence op = new OperatorPrecedence();
    op.logicalAndVsDivide();
  }

  void relational() {
    //operator + is evaluated before operator <
    if (value(3) + value(2) < value(6)) {
      System.out.println("condition is true");
    }
  }

  void logicalOperator() {
    //it prints nothing, as it is false
    if (2 + 3 < 5 && 2 > 1) {
      System.out.println("condition is true");
    }
  }


  void complex() {
    //condition true
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
    int result = a++ / b - a;
    // 5/7 -> 0
    // 5++ -> 6
    // 0 - 6 = -6
    System.out.println(result); //-6
  }

  void logicalAndVsDivide() {
    if (4 / 2 == 2 && 2 == 2) {
      System.out.println("done");
    }
  }

  void ternary() {
    int a = 9;
    int b = 3;
    var result = ++a >= 10 ? b-- <= 2
        ? "A" : "B" : "C";
    /*
    1. ++a>=10 -> 10>=10 -> then we can exclude the last block "C"
    2. b--<=2 ? "A" : "B"
    3. (b--<=2) --> false (post decrease) -> "B"
     */

    System.out.println(result);  // "B"
  }


}
