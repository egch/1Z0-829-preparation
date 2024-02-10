package org.enricogiurin.ocp17.book.ch9.map;

import java.util.HashMap;
import java.util.Map;

public class MapUtilities {

  static Map<String, Integer> getScores() {
    Map<String, Integer> scores = new HashMap<>();
    scores.put("John", 30);
    scores.put("Marc", 20);
    scores.put("Oliver", 18);
    scores.put("Simon", 29);
    return scores;
  }

  static Map<Integer, String> immutableMap() {
    return Map.of(1, "enrico",
        2, "mario",
        3, "roberto",
        4, "andrea",
        5, "simone",
        6, "stefano");
  }

}
