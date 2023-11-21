package org.enricogiurin.ocp17.book.ch4.time;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;

public class UseOfLocalDateTime {

  public static void main(String[] args) {
    UseOfLocalDateTime useOfLocalDateTime = new UseOfLocalDateTime();
    useOfLocalDateTime.createLocalDateTime();
  }

  void now() {
    LocalDate date = LocalDate.now();
    LocalTime time = LocalTime.now();
    LocalDateTime dateTime = LocalDateTime.now();
    ZonedDateTime zonedDateTime = ZonedDateTime.now();

    System.out.println(date);  //2023-10-21
    System.out.println(time); //22:45:09.164355
    System.out.println(dateTime); //2023-10-21T22:45:09.164446  (mind the T)
    System.out.println(
        zonedDateTime); //2023-10-21T22:45:09.165079+02:00[Europe/Zurich] (mind the timezone)
  }

  void createLocalDateTime() {
    LocalDateTime now = LocalDateTime.now();

    //with month as an int
    LocalDateTime ldtFullWithNS = LocalDateTime.of(2023, 11, 10, 10, 20, 10, 100);
    LocalDateTime ldtFull = LocalDateTime.of(2023, 11, 10, 10, 20, 10);
    LocalDateTime ldtNoSec = LocalDateTime.of(2023, 11, 10, 10, 10);

    //with month as an enum Month
    LocalDateTime ldtMonthEnumWithNS = LocalDateTime.of(2023, Month.NOVEMBER, 10, 10, 10, 10, 1);
    LocalDateTime ldtMonthEnum = LocalDateTime.of(2023, Month.NOVEMBER, 10, 10, 10, 10);
    LocalDateTime ldtMonthEnumNoSec = LocalDateTime.of(2023, Month.NOVEMBER, 10, 10, 10);

    LocalDateTime ldtComposed = LocalDateTime.of(LocalDate.now(),
        LocalTime.now());
    System.out.println(ldtComposed);
  }

  void ofEpochSecond() {
    ZoneOffset zurichOffset = ZoneOffset.ofHours(2);

    //Keep in mind that System.currentTimeMillis() returns ms, while the method expects seconds
    LocalDateTime ofEpochSecond = LocalDateTime.ofEpochSecond(System.currentTimeMillis() / 1000, 0,
        zurichOffset);
    System.out.println(ofEpochSecond); //2023-10-22T03:41:27
  }

}
