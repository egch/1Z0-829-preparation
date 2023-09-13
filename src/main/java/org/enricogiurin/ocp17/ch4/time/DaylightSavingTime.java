package org.enricogiurin.ocp17.ch4.time;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class DaylightSavingTime {

  public static void main(String[] args) {
    new DaylightSavingTime().daylight();

  }

  void daylight() {
    ZoneId usEastern = ZoneId.of("US/Eastern");
    System.out.println(usEastern);
    LocalDate dayLight = LocalDate.of(2022, Month.MARCH, 13);
    LocalTime timeDayLight = LocalTime.of(1, 30);
    ZonedDateTime zonedDateTime = ZonedDateTime.of(dayLight, timeDayLight, usEastern);
    System.out.println(zonedDateTime); //2022-03-13T01:30-05:00[US/Eastern]
    //now we increase time of one hour
    //at 2am the clock is changed one hour forward
    timeDayLight = timeDayLight.plusHours(1L);
    zonedDateTime = ZonedDateTime.of(dayLight, timeDayLight,
        usEastern); //2022-03-13T03:30-04:00[US/Eastern]
    //the GMT is changed
    System.out.println(zonedDateTime);

  }


}
