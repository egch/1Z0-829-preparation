package org.enricogiurin.ocp17.book.ch3.usageofswitch;


public class SwitchDay {

  public static void main(String[] args) {
    SwitchDay aSwitch = new SwitchDay();
    aSwitch.workOrChillOut(DayOfWeek.THURSDAY);
    aSwitch.workOrChillOut(DayOfWeek.SUNDAY);
  }


  void workOrChillOut(DayOfWeek day) {
    //with the new switch, I can have multiple cases in the same line
    switch (day) {
      case MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY:
        System.out.println("You have to work!");
        break;
      default:
        System.out.println("Enjoy your weekend!");
    }
  }

}

