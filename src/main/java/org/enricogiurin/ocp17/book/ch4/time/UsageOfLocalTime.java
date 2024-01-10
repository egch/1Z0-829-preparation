package org.enricogiurin.ocp17.book.ch4.time;

import java.time.Duration;
import java.time.LocalTime;

public class UsageOfLocalTime {

  public static void main(String[] args) {
    new UsageOfLocalTime().of();
  }
  void in10min(){
    LocalTime in10 = LocalTime.now().plus(Duration.ofMinutes(10));
    System.out.println(in10);
  }

  void of() {
    LocalTime localTimeHM = LocalTime.of(12, 15);
    System.out.println(localTimeHM); //12:15
    LocalTime localTimeHMS = LocalTime.of(12, 14, 45);
    System.out.println(localTimeHMS); //12:14:45
    //4 parameters here
    LocalTime localTimeHMSN = LocalTime.of(12, 15, 45, 376);
    System.out.println(localTimeHMSN); //12:15:45.000000376
  }

}
