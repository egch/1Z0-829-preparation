package org.enricogiurin.ocp17.book.ch9;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;

public class UsageOfMap {

  public static void main(String[] args) {
    new UsageOfMap().insertNull();
  }

  void createMap() {
    //this is an immutable map
    Map<String, Integer> age = Map.ofEntries(Map.entry("Enrico", 40),
        Map.entry("Mario", 30),
        Map.entry("John", 18));
  }

  void containsKeyValue() {
    Map<String, Integer> map = new HashMap<>();
    map.put("a", 1);
    map.put("b", 2);
    map.put("c", 1);

    boolean contains = map.containsKey("a");
    System.out.println(contains);  //true

    contains = map.containsValue(2);
    System.out.println(contains);
  }

  void merge() {
    BiFunction<Integer, Integer, Integer> maxFunction = Math::max;
    Map<String, Integer> scores = getScores();

    scores.merge("John", 20, maxFunction);
    System.out.println(scores.get("John"));  //30

    scores.merge("New", 20, maxFunction);
    System.out.println(scores.get("New"));  //20
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

  void insertNull() {
    Map<String, Integer> scores = getScores();
    scores.put(null, 12);
    Integer nullKey = scores.get(null);
    System.out.println(nullKey); //12

  }

  void replaceAll() {
    Map<String, Integer> scores = getScores();
    BiFunction<String, Integer, Integer> doubleIfGreater = (k, v) -> {
      if (v > 25) {
        return 2 * v;
      }
      return v;
    };
    scores.replaceAll(doubleIfGreater);
    System.out.println(scores); //{Marc=20, Oliver=18, Simon=58, John=60}
  }


  void getOrDefault() {
    Map<String, Integer> scores = getScores();
    Integer value = scores.getOrDefault("John", 40);  //30
    System.out.println(value);
    value = scores.getOrDefault("Unknown", 40);  //40
    System.out.println(value);

  }

  private Map<String, Integer> getScores() {
    Map<String, Integer> scores = new HashMap<>();
    scores.put("John", 30);
    scores.put("Marc", 20);
    scores.put("Oliver", 18);
    scores.put("Simon", 29);
    return scores;
  }


}
