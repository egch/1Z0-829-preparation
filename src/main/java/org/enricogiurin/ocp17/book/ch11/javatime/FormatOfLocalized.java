package org.enricogiurin.ocp17.book.ch11.javatime;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

public class FormatOfLocalized {

  public static void main(String[] args) {
    new FormatOfLocalized().ofLocalizedDate();
  }

  void ofLocalizedTime() {
    LocalTime now = LocalTime.now();

    DateTimeFormatter ofLocalizedTime = DateTimeFormatter
        .ofLocalizedTime(FormatStyle.SHORT);

    String result = now.format(ofLocalizedTime);
    System.out.println(result);  //04.17
  }

  void ofLocalizedDateTime() {
    LocalDateTime now = LocalDateTime.now();
    DateTimeFormatter localizedDateTime = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT);

    String result = now.format(localizedDateTime);
    System.out.println(result);  //03/01/2024, 04:20
  }

  void ofLocalizedDateTimeFull() {
    ZonedDateTime now = ZonedDateTime.now();
    DateTimeFormatter localizedDateTime = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.LONG);

    String result = now.format(localizedDateTime);
    System.out.println(result);  //3 January 2024 at 04:21:42 CET
  }

  void ofLocalizedDate() {
    LocalDate localDate = LocalDate.of(2023, Month.NOVEMBER, 10);
    LocalTime localTime = LocalTime.of(0, 0);
    LocalDateTime localDateTime = LocalDateTime.of(localDate, localTime);

    //The DateTimeFormatter is created with ofLocalizedDate().
    // It knows how to format date fields but not time field
    DateTimeFormatter dtfOfLocalizedDate = DateTimeFormatter
        .ofLocalizedDate(FormatStyle.SHORT);

    //this can handle date
    dtfOfLocalizedDate.format(localDate);
    //this can also handle date
    dtfOfLocalizedDate.format(localDateTime);
    //this has no clue what a date is
    //Exception in thread "main" java.time.temporal.UnsupportedTemporalTypeException: Unsupported field: DayOfMonth
    dtfOfLocalizedDate.format(localTime);
  }


}
