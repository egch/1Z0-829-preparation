package org.enricogiurin.ocp17.book.ch9.map;

import static org.enricogiurin.ocp17.book.ch9.map.MapUtilities.immutableMap;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MethodsOfMap2 {

  public static void main(String[] args) {
    new MethodsOfMap2().inspectMap();
  }


  void inspectMap() {
    Map<Integer, String> map = immutableMap();
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

  private Map<Integer, String> buildMutableMap() {
    HashMap<Integer, String> mutableMap = new HashMap<>(immutableMap());
    return mutableMap;
  }


}
