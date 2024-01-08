package org.enricogiurin.ocp17.book.ch3.usageofswitch;


public class SwitchExpression {

  public static void main(String[] args) {
    new SwitchExpression().switchExpressionWithNoReturnValueAssigned();
  }

  void printItalianDay(DayOfWeek day) {
    var result = switch (day) {
      case MONDAY -> "lunedi";
      case TUESDAY -> "martedi";
      case WEDNESDAY -> "mercoledi";
      case THURSDAY -> "giovedi";
      case FRIDAY -> "venerdi";
      case SATURDAY -> "sabato";
      case SUNDAY -> "domenica";
    }; //mind the semicolon
    System.out.println("today is: " + result);
  }

  void printItalianDayWithDefault(DayOfWeek day) {
    var result = switch (day) {
      case MONDAY -> "lunedi";
      case TUESDAY -> "martedi";
      case WEDNESDAY -> "mercoledi";
      case THURSDAY -> "giovedi";
      case FRIDAY -> "venerdi";
      default -> "weekend";
    };  //mind the semicolon
    System.out.println("today is: " + result);
  }

  void workOrLaziness(DayOfWeek day) {
    var result = switch (day) {
      case MONDAY, TUESDAY, WEDNESDAY, THURSDAY -> "I hate my fucking job";
      case FRIDAY -> "almost weekend";
      default -> "weekend";
    };  //mind the semicolon
    System.out.println("today is: " + result);
  }

  void switchExpressionWithNoReturnValueAssigned() {
    int cnt = 0;
    char c = 'a';
    //there is no return value assigned so the default is not needed
    switch (c) {
      case 'a' -> cnt++;
      case 'b' -> cnt++;
    }
    System.out.println(cnt); //1
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
