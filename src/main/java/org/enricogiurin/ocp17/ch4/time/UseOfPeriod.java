package org.enricogiurin.ocp17.ch4.time;

import java.time.LocalDateTime;
import java.time.Period;

public class UseOfPeriod {

  public static void main(String[] args) {
    new UseOfPeriod().period();
  }

  void period() {
    LocalDateTime now = LocalDateTime.now();
    System.out.println(now);     //2023-09-03T03:07:43.919980
    Period period = Period.ofDays(5).plusYears(1);
    System.out.println(period);  //P1Y5D
    LocalDateTime future = now.plus(period);
    System.out.println(future); //2024-09-08T03:07:43.919980
  }

}
