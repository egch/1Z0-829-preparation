package org.enricogiurin.ocp17.ch4.time;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.temporal.ChronoUnit;

public class UseOfPeriod {

  public static void main(String[] args) {
    new UseOfPeriod().methodsOfPeriod();
  }

  void period() {
    LocalDateTime now = LocalDateTime.now();
    System.out.println(now);     //2023-09-03T03:07:43.919980
    Period period = Period.ofDays(5).plusYears(1);
    System.out.println(period);  //P1Y5D
    LocalDateTime future = now.plus(period);
    System.out.println(future); //2024-09-08T03:07:43.919980
  }

  void methodsOfPeriod() {
    Period period = Period.ofDays(4).plusMonths(2);
    int days = period.getDays();
    int months = period.getMonths();
    System.out.println("days: "+days+" months: "+months);
    //no methods such as getHours, getMinutes, getDays

  }


  void performTask() {
    LocalDate start = LocalDate.now();
    Period period = Period.ofDays(1);
    LocalDate end = start.plus(1, ChronoUnit.WEEKS);
    performTask(start, end, period);

  }
  private void performTask(LocalDate start, LocalDate end, Period period) {
    LocalDate up = start;
    while (up.isBefore(end)){
      System.out.println("performing task");
      up = up.plus(period);
    }
    System.out.println("all taks completed");
  }

  void parsePeriod() {
    Period period = Period.parse("P2M3D");
    System.out.println(period);

    //Exception in thread "main" java.time.format.DateTimeParseException: Text cannot be parsed to a Period
    try {
      Period.parse("2M3D");
    }catch (DateTimeException e) {
      e.printStackTrace();
    }
  }

}
