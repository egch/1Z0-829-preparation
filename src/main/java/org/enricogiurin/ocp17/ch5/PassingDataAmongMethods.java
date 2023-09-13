package org.enricogiurin.ocp17.ch5;

import java.util.HashMap;
import java.util.Map;

public class PassingDataAmongMethods {

  public static void main(String[] args) {
    PassingDataAmongMethods instance = new PassingDataAmongMethods();
    int a = 2;
    instance.sum(a);
    //2
    System.out.println(a);

    //now with object
    HashMap<String, String> map = new HashMap<>();
    instance.addEntry(map);
    //Zurigo
    System.out.println(map.get("Enrico"));

  }

  void sum(int a) {
    //this has no effect -> passing by value
    a += 5;
  }

  void addEntry(Map<String, String> map) {
    map.put("Enrico", "Zurigo");
    //this has no effect -> but the content of map is changed before
    map = null;
  }

}
