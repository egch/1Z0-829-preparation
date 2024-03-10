package org.enricogiurin.ocp17.book.ch4.time;

import java.time.Duration;
import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;
import java.util.concurrent.TimeUnit;

public class UsageOfInstant {

  public static void main(String[] args) {
    new UsageOfInstant().parseInstant();
  }

  //I can use toInstant only with ZonedDateTime (not LDT)
  void toInstant() {
    ZonedDateTime zdtZurich = ZonedDateTime.now(ZoneId.of("Europe/Zurich"));
    System.out.println(zdtZurich); //2023-10-23T01:07:02.283028+02:00[Europe/Zurich]
    Instant instant = zdtZurich.toInstant();
    System.out.println(instant); //2023-10-22T23:07:02.283028Z
  }

  void differentTZ() {
    ZonedDateTime zdtZurich = ZonedDateTime.now(ZoneId.of("Europe/Zurich"));
    ZonedDateTime zdTLA = ZonedDateTime.now(ZoneId.of("America/Los_Angeles"));
    Instant instantZRH = zdtZurich.toInstant();
    Instant instantLA = zdTLA.toInstant();
    System.out.println("ZRH: " + instantZRH);  //ZRH: 2023-10-22T23:12:13.113747Z
    System.out.println("LA: " + instantLA);     //LA: 2023-10-22T23:12:13.117154Z

    Duration duration = Duration.between(instantZRH, instantZRH);
    System.out.println(duration);  //PT0S
  }

  void durationBetweenTwoInstants() {
    Instant before = Instant.now();
    for (int j = 0; j < 100; j++) {
      //do nothing
    }
    Instant now = Instant.now();
    Duration duration = Duration.between(before, now);
    System.out.println(
        "time elapsed: %d ns ".formatted(duration.getNano()));  //time elapsed: 3000 ns
  }

  void addToInstant() {
    Instant now = Instant.now();
    Instant then = now.plus(1, ChronoUnit.DAYS);
    //2024-01-08T07:47:52.101744Z
    System.out.println(then);
    //adding a year - throws an exception
    try {
      //java.time.temporal.UnsupportedTemporalTypeException: Unsupported unit: Years
      Instant inOneYear = now.plus(1, ChronoUnit.YEARS);
    } catch (Exception e) {
      e.printStackTrace();
    }
    //same as adding a week
    try {
      //java.time.temporal.UnsupportedTemporalTypeException: Unsupported unit: Weeks
      now.plus(1, ChronoUnit.WEEKS);
    }catch (Exception e){
      e.printStackTrace();
    }
  }
  void parseInstant() {
    Instant instant = Instant.parse("2024-03-01T14:02:30.123Z");
    //this has no effect since Instant is immutable
    instant.plus(1, ChronoUnit.HOURS);
    System.out.println(instant); //2024-03-01T14:02:30Z
  }


}
