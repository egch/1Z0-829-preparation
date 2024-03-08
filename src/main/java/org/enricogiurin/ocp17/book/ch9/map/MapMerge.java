package org.enricogiurin.ocp17.book.ch9.map;

import static org.enricogiurin.ocp17.book.ch9.map.MapUtilities.getScores;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.function.BiFunction;

public class MapMerge {

  public static void main(String[] args) {
    new MapMerge().mergeNull2();
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

  void mergeNull2() {
    Map<Integer, Integer> map = new HashMap<>();
    BiFunction<Integer, Integer, Integer> mergeFunction = (v1, v2) -> null;

    map.put(1, 5);
    map.put(2, 6);
    map.put(3, null);
    map.merge(1, 10, mergeFunction);
    //If the specified key is not already associated with a value or is associated with null, associates it with the given non-null value
    //here the value of 3 is null, so it's going take the default value 10
    map.merge(3, 10, mergeFunction);

    System.out.println(map);  //   {2=6, 3=10}
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
