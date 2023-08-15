package org.enricogiurin.ocp17.ch3;

public class SwitchYield {

  public static void main(String[] args) {
    new SwitchYield().exampleWithYield(6);
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

  void switchComplex() {
    int parameter = 5;
    int result = switch (parameter) {
      case 0 -> 0;
      case 1 -> build();
      default -> 5;

    };
  }


  int build() {
    return 4;
  }


}

