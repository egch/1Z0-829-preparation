package org.enricogiurin.ocp17.ch4;

import java.time.Duration;
import java.time.Instant;

public class Period {

  public static void main(String[] args) {
    new Period().duration();
  }

  void duration() {
    var now = Instant.now();
    var later = Instant.now();
    var duration = Duration.between(now, later);

    System.out.println("elapsed time: " + duration.toNanos() + "ns");
  }
}
