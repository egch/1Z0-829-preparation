package org.enricogiurin.ocp17.ch4.time;

import java.time.LocalDate;
import java.time.Month;
import java.time.temporal.ChronoUnit;


public class UseOfLocalDate {

  public static void main(String[] args) {
    new UseOfLocalDate().invalidAdd();
  }
  void manipulatingDates() {
    LocalDate now = LocalDate.now();
    now = now.plus(1L, ChronoUnit.DAYS);
    now = now.plusDays(1L);

    now = now.plusWeeks(1L);
    now = now.plusWeeks(1L).minusDays(1);
    System.out.println(now);  //2023-11-06
  }

  void invalidAdd() {
    // I cannot add minutes to LD
    LocalDate now = LocalDate.now();
    //Exception in thread "main" java.time.temporal.UnsupportedTemporalTypeException: Unsupported unit: Minutes
    now = now.plus(1, ChronoUnit.MINUTES);
  }


  void lapYear() {
    //2020 is a lap year
    LocalDate localDate = LocalDate.of(2020, Month.FEBRUARY, 28);
    localDate = localDate.plusDays(1L);
    System.out.println(localDate); //2020-02-29

    //2023 is NOT a lap year
    localDate = LocalDate.of(2023, Month.FEBRUARY, 28);
    localDate = localDate.plusDays(1L);
    System.out.println(localDate); //2023-03-01
  }

  void invalidLocalDate() {
    //Exception in thread "main" java.time.DateTimeException: Invalid value for MonthOfYear (valid values 1 - 12): 16
    LocalDate notALD = LocalDate.of(2023, 16, 12);
  }

}
