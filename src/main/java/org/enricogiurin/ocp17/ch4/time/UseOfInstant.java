package org.enricogiurin.ocp17.ch4.time;

import java.time.Duration;
import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class UseOfInstant {

  public static void main(String[] args) {
    new UseOfInstant().differentTZ();
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
    System.out.println("ZRH: "+instantZRH);  //ZRH: 2023-10-22T23:12:13.113747Z
    System.out.println("LA: "+instantLA);     //LA: 2023-10-22T23:12:13.117154Z

    Duration duration = Duration.between(instantZRH, instantZRH);
    System.out.println(duration);  //PT0S

  }



}
