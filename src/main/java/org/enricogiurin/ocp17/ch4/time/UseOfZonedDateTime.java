package org.enricogiurin.ocp17.ch4.time;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Set;

public class UseOfZonedDateTime {

  public static void main(String[] args) {
    new UseOfZonedDateTime().zoneDateTime();
  }
  void zoneDateTime() {
    LocalDateTime now = LocalDateTime.now();
    ZoneId myZone = ZoneId.systemDefault();
    System.out.println("Output of systemDefault(): " +myZone);
    ZonedDateTime myZonedDateTime = ZonedDateTime.of(now, myZone);
    //2023-09-03T02:54:37.528950+02:00[Europe/Zurich]
    System.out.println(myZonedDateTime);

    //calculating time in bucharest now
    ZoneId zoneBucharest = ZoneId.of("Europe/Bucharest");
    ZonedDateTime zonedDateTimeInBucharest = ZonedDateTime.of(now, zoneBucharest);
    System.out.println(zonedDateTimeInBucharest);
    ZonedDateTime bucharestZonedDateTime = ZonedDateTime.now(zoneBucharest);

    //2023-09-03T03:57:27.798509+03:00[Europe/Bucharest]
    System.out.println(bucharestZonedDateTime);

  }

  void showZones() {
    Set<String> availableZoneIds = ZoneId.getAvailableZoneIds();
    System.out.println(String.format("found %d time zones", availableZoneIds.size()));
    availableZoneIds.forEach(System.out::println);
  }

  void invalidZoneId() {
    //Exception in thread "main" java.time.zone.ZoneRulesException: Unknown time-zone ID: aa
    ZoneId.of("aa");
  }

}
