package org.enricogiurin.ocp17.book.ch9.map;

import java.util.Map;

public class CreateMap {

  public static void main(String[] args) {
    CreateMap createMap = new CreateMap();
    createMap.of();
  }

  //create an immutable map
  void of() {
    //k1,v1, k2,v2, k3,v3...
    Map<String, Integer> ages = Map.of("enrico", 40, "John", 25, "Mark", 30);
    System.out.println(ages.getClass().getName()); //java.util.ImmutableCollections$MapN
  }

  //create an immutable map
  void ofEntries() {
    Map<String, Integer> heights = Map.ofEntries(Map.entry("Mark", 180),
        Map.entry("John", 174), Map.entry("Simon", 167));
  }

}
