package org.enricogiurin.ocp17.book.ch9.map;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.function.BiConsumer;

public class MethodsOfMap {

  public static void main(String[] args) {
    new MethodsOfMap().forEach();
  }


  void inspectMap() {
    Map<Integer, String> map = buildMap();
    System.out.println(map.containsKey(1));
    System.out.println(map.containsValue("roberto"));
    Set<Map.Entry<Integer, String>> entries = map.entrySet();
    entries.forEach(entry ->
        System.out.println(entry.getKey() + ": " + entry.getValue())
    );
    map.forEach((k, v) -> System.out.println(k + "-" + v));
  }

  void modifyMap() {
    Map<Integer, String> map = buildMutableMap();
    String value = map.putIfAbsent(10, "ciccio");
    //old value - null
    System.out.println(value);
    //old value - roberto
    value = map.putIfAbsent(3, "ciccio");
    System.out.println(value);

    map.clear();
    System.out.println(map.isEmpty());
  }

  private Map<Integer, String> buildMap() {
    return Map.of(1, "enrico",
        2, "mario",
        3, "roberto",
        4, "andrea",
        5, "simone",
        6, "stefano");
  }

  private Map<Integer, String> buildMutableMap() {
    HashMap<Integer, String> mutableMap = new HashMap<>(buildMap());
    return mutableMap;
  }

  void forEach() {
    //using lambda
    Map<Integer, String> map = buildMap();
    BiConsumer<Integer, String> biConsumer =
        (key, value) -> System.out.println("key: %s - value: %s".formatted(key, value));
    //NOTE! it uses a BIConsumer, not a consumer!
    map.forEach(biConsumer);
  }
}
