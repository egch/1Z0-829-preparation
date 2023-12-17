package org.enricogiurin.ocp17.book.ch3.usageofswitch;

public class SwitchExpressionWithYield {

  public static void main(String[] args) {
    new SwitchExpressionWithYield().exampleWithYield(6);
  }

  void exampleWithYield(int x) {
    var result = switch (x) {
      case 1 -> "x is 5";
      default -> {
        //yield is used instead of return
        if (x > 5) {
          yield "greater than 5";
        } else {
          yield "lower or equal than 5";
        }
      }
    };
    System.out.println(result);
  }

  void switchYield() {
    final int score1 = 8, score2 = 3;
    char myScore = 7;
    var goal = switch (myScore) {
      default -> {
        if (10 > score1) {
          yield "unknown";
        } else {
          yield "ciao";

        }
      }
      case score1 -> "great";
      case 2, 4, 6 -> "good";
      case score2, 0 -> {
        yield "bad";
      }
    };
    System.out.println(goal);
  }

  void wrongYield() {

    int magicNumber = 7;
    var ok = switch (magicNumber) {
      //break is not allowed in a switch expression
      //case 7 -> true; break;

      //missing semicolon
      //case 9 -> {yield true}

      //missing brackets
      //case 11 -> yield true;

      //you can't mix switch expression and switch statement syntax.
      //case 13: {yield true;}
      default -> false;
      };
  }

}

