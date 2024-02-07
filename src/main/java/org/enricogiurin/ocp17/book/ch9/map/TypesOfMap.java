package org.enricogiurin.ocp17.book.ch9.map;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class TypesOfMap {

  public static void main(String[] args) {
    new TypesOfMap().treeMapWithComparator();
  }

  void hashMap() {
    //this is a mutable map
    Map<String, Integer> weights = new HashMap<>();
    weights.put("John", 89);
    weights.put("Mark", 91);
    weights.put("Albert", 75);
    //inserting order (theoretically) is not kept
    System.out.println(weights);
  }

  void linkedHashMap() {
    Map<String, Integer> scores = new LinkedHashMap<>();
    scores.put("teamA", 20);
    scores.put("teamB", 30);
    scores.put("teamC", 18);
    //inserting order is kept
    System.out.println(scores); //{teamA=20, teamB=30, teamC=18}
  }

  void treeMap() {
    var categories = new TreeMap<String, String>();
    categories.put("Category1", "Value1");
    categories.put("Category3", "Value3");
    categories.put("Category2", "Value2");
    //keys are sorted by their order
    //{Category1=Value1, Category2=Value2, Category3=Value3}
    System.out.println(categories);
  }

  void treeMapWithComparator() {
    var treeMap = new TreeMap<String, Integer>((k1, k2) -> k1.length() - k2.length());
    treeMap.put("ab", 12);
    treeMap.put("abc", 123);
    treeMap.put("d", 100);
    System.out.println(treeMap);  //{d=100, ab=12, abc=123}
  }

}
