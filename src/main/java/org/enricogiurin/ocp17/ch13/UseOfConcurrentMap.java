package org.enricogiurin.ocp17.ch13;

import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

public class UseOfConcurrentMap {

  public static void main(String[] args) {
    //   new UseOfConcurrentMap().notConcurrentMap();
    new UseOfConcurrentMap().concurrentMap();
  }

  void notConcurrentMap() {
    var map = new HashMap<String, Integer>();
    map.put("a", 1);
    map.put("b", 2);
    map.put("c", 3);

    //Exception in thread "main" java.util.ConcurrentModificationException
    for (String key : map.keySet()) {
      map.remove(key);
    }
  }

  void concurrentMap() {
    //here we use ConcurrentHashMap
    var map = new ConcurrentHashMap<String, Integer>();
    map.put("a", 1);
    map.put("b", 2);
    map.put("c", 3);
    //safe operation
    for (String key : map.keySet()) {
      map.remove(key);
    }
  }
}
