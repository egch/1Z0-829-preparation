package org.enricogiurin.ocp17.ch4.time;

import java.time.Duration;
import java.time.Instant;

public class UseOfDuration {

  public static void main(String[] args) {
    new UseOfDuration().duration();
  }

  void duration() {
    var now = Instant.now();
    var later = Instant.now();
    System.out.println("instant: "+later); //2023-09-03T19:55:15.400194Z
    var duration = Duration.between(now, later);

    System.out.println("elapsed time: " + duration.toNanos() + "ns");
  }
}
