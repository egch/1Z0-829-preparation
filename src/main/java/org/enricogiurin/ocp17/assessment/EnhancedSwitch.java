package org.enricogiurin.ocp17.assessment;

public class EnhancedSwitch {

  public static void main(String[] args) {
    new EnhancedSwitch().missingYield();
  }

  void missingYield() {
    final int s1 = 8, s2 = 3;
    char ms = 7;
    var result = switch (ms) {
      default -> {
        if (10 > s1) {
          yield "unknown";
        }
        //you need this!
        yield "aaa";
      }
      case s1 -> "great";
      case 2, 4, 6 -> "good";

      //does not compile
/*      case s2, 0 -> {
        "bad";
      }*/
    };
    System.out.println(result);


  }

}
