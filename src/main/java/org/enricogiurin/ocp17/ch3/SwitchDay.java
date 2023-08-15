package org.enricogiurin.ocp17.ch3;

public class SwitchDay {

  public static void main(String[] args) {
    SwitchDay aSwitch = new SwitchDay();
    aSwitch.workOrChillOut(DayOfWeek.THURSDAY);
    aSwitch.workOrChillOut(DayOfWeek.SUNDAY);
    aSwitch.printItalianDay(DayOfWeek.SATURDAY);
  }


  void workOrChillOut(DayOfWeek day) {
    //with the new switch I can have multiple case in the same line
    switch (day) {
      case MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY:
        System.out.println("You have to work!");
        break;
      default:
        System.out.println("Enjoy your weekend!");

    }
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
    };
    System.out.println("today is: " + result);
  }
}

