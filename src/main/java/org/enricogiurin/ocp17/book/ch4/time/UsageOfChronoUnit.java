package org.enricogiurin.ocp17.book.ch4.time;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;

public class UsageOfChronoUnit {

  public static void main(String[] args) {
    new UsageOfChronoUnit().between();
  }

  void between() {
    var date = LocalDate.of(2022, Month.NOVEMBER, 6);
    var time = LocalTime.of(1, 30);
    var zone = ZoneId.of("US/Eastern");
    ZonedDateTime zdt1 = ZonedDateTime.of(date, time, zone);
    ZonedDateTime zdt2 = zdt1.plus(1, ChronoUnit.HOURS);
    long between = ChronoUnit.HOURS.between(zdt1, zdt2);
    System.out.println(between);  //1
  }

}
