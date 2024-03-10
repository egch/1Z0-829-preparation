package org.enricogiurin.ocp17.book.ch9.map;

import static org.enricogiurin.ocp17.book.ch9.map.MapUtilities.getScores;
import static org.enricogiurin.ocp17.book.ch9.map.MapUtilities.immutableMap;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;

public class MethodsOfMap {

  public static void main(String[] args) {
    new MethodsOfMap().entrySet();
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

    //NOTE" it's not contains(), but contains key
    boolean contains = map.containsKey("a");
    System.out.println(contains);  //true

    //NOTE" it's not contains(), but contains value
    contains = map.containsValue(2);

    System.out.println(contains);
  }

  void overwriteValue() {
    Map<String, Integer> map = new HashMap<>();
    Integer oldValue = map.put("a", 1);  //null
    System.out.println(oldValue);
    oldValue = map.put("a", 2);
    System.out.println(oldValue);  //1
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

  void keySet() {
    Map<String, Integer> map = getScores();
    //it returns a set
    Set<String> keys = map.keySet();
    //[Marc, Oliver, Simon, John]
    System.out.println(keys);
  }

  void values() {
    Map<String, Integer> map = getScores();
    //it returns a Collection!
    Collection<Integer> values = map.values();
    //[20, 18, 29, 30]
    System.out.println(values);

    //forEach() is defined in the Interface Iterable<T> which is extended by Collection
    values.forEach(System.out::println);
  }

  void entrySet() {
    Map<String, Integer> map = getScores();
    Set<Entry<String, Integer>> entries = map.entrySet();
    //[Marc=20, Oliver=18, Simon=29, John=30]
    System.out.println(entries);

    //using for
    for (Entry<String, Integer> entry : entries) {
      System.out.println("%s: %d".formatted(entry.getKey(), entry.getValue()));
    }
  }

  void forEach() {
    //using lambda
    Map<Integer, String> map = immutableMap();
    BiConsumer<Integer, String> biConsumer =
        (key, value) -> System.out.println("key: %s - value: %s".formatted(key, value));
    //NOTE! it uses a BIConsumer, not a consumer!
    map.forEach(biConsumer);
  }


}
