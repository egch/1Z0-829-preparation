package org.enricogiurin.ocp17.ch3;

public class SwitchExpression {

  void printItalianDay(DayOfWeek day) {
    var result = switch (day) {
      case MONDAY -> "lunedi";
      case TUESDAY -> "martedi";
      case WEDNESDAY -> "mercoledi";
      case THURSDAY -> "giovedi";
      case FRIDAY -> "venerdi";
      case SATURDAY -> "sabato";
      case SUNDAY -> "domenica";
    };
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
    };
    System.out.println("today is: " + result);
  }

  void workOrLaziness(DayOfWeek day) {
    var result = switch (day) {
      case MONDAY, TUESDAY, WEDNESDAY, THURSDAY -> "I hate my fucking job";
      case FRIDAY -> "almost weekend";
      default -> "weekend";
    };
    System.out.println("today is: " + result);
  }



}
