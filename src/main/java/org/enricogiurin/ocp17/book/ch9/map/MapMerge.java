package org.enricogiurin.ocp17.book.ch9.map;

import static org.enricogiurin.ocp17.book.ch9.map.MapUtilities.getScores;

import java.util.Map;
import java.util.Map.Entry;
import java.util.function.BiFunction;

public class MapMerge {

  public static void main(String[] args) {
    new MapMerge().mergeWhenValueIsNull();
  }

  void merge() {
    BiFunction<Integer, Integer, Integer> maxFunction = Math::max;
    Map<String, Integer> scores = getScores();

    scores.merge("John", 20, maxFunction);
    System.out.println(scores.get("John"));  //30

    scores.merge("New", 20, maxFunction);
    System.out.println(scores.get("New"));  //20
  }

  void merge2() {
    Map<String, Integer> scores = getScores();
    BiFunction<Integer, Integer, Integer> merger = (v1, v2) -> v1 + v2;
    Integer mergedValue = scores.merge("John", 24, merger);
    System.out.println(mergedValue); //54 (24+30)
  }

  void mergeNull() {
    BiFunction<Integer, Integer, Integer> nullFunction = (v1, v2) -> null;
    Map<String, Integer> scores = getScores();
    scores.merge("John", 30, nullFunction);  ////John deleted
    scores.merge("Unknown", 30, nullFunction);  //Unknown added with default value (30)
    boolean contains = scores.containsKey("John");
    System.out.println(contains);  //false
    Integer unknown = scores.get("Unknown");
    System.out.println(unknown);  //30
  }

  void mergeWhenValueIsNull() {
    Map<String, Integer> scores = getScores();
    scores.putIfAbsent("Philip", null);
    for (Entry<String, Integer> entry : scores.entrySet()) {
      scores.merge(entry.getKey(), 10, Integer::sum);
    }
    //{Marc=30, Oliver=28, Simon=39, John=40, Philip=10}
    System.out.println(scores);
    Integer value = scores.get("Philip");
    //Philip gets just the new value, as before it was null
    System.out.println(value); //10

  }

}
