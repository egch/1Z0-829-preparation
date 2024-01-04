package org.enricogiurin.ocp17.book.ch10.collectors;


import static org.enricogiurin.ocp17.book.ch10.StreamUtils.fruitStream;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CollectorsToCollection {

  public static void main(String[] args) {
    new CollectorsToCollection().toTreeMap();
  }

  void collectToCollection() {
    Stream<String> fruits = fruitStream();
    ArrayList<String> result = fruits
        .collect(Collectors.toCollection(() -> new ArrayList<>(10)));

    fruits = fruitStream();
    HashSet<String> set = fruits.collect(Collectors.toCollection(HashSet::new));

  }

  void toMap() {
    Stream<String> fruits = fruitStream();
    Map<Integer, String> map = fruits
        .collect(Collectors.toMap(
            (String s) -> s.length(),
            (String t) -> t,
            (String s1, String s2) -> s1 + ", " + s2));
    //{4=Kiwi, Pear, Lime, 5=Apple, Grape, Peach, Mango, Lemon, 6=Orange, Banana, Banana}
    System.out.println(map);
  }

  void toTreeMap() {
    Stream<String> stream = fruitStream();
    TreeMap<Integer, String> treeMap = stream.collect(Collectors.toMap(
        (String s) -> s.length(),
        (String t) -> t.toUpperCase(),
        (String s1, String s2) -> s1 + ", " + s2,
        () -> new TreeMap<>((n1, n2) -> n2 - n1)));
    //{6=ORANGE, BANANA, BANANA, 5=APPLE, GRAPE, PEACH, MANGO, LEMON, 4=KIWI, PEAR, LIME}
    System.out.println(treeMap);
  }


  void map() {
    Stream<String> fruitStream = fruitStream();
    Map<Integer, String> map = fruitStream.collect(
        Collectors.toMap(String::length, f -> f, (f1, f2) -> f1 + ", " + f2));
    System.out.println(
        map);  //{4=Kiwi, Pear, Lime, 5=Apple, Grape, Peach, Mango, Lemon, 6=Banana, Orange}
    System.out.println(map.getClass());  //class java.util.TreeMap
  }

  void treeMap() {
    Stream<String> fruitStream = fruitStream();
    TreeMap<Integer, String> map = fruitStream.collect(
        Collectors.toMap(String::length, //keymapper
            f -> f,                      //value mapper
            (f1, f2) -> f1 + ", " + f2,  //merge function
            TreeMap::new));              //mapFactory

    System.out.println(
        map);  //{4=Kiwi, Pear, Lime, 5=Apple, Grape, Peach, Mango, Lemon, 6=Banana, Orange}
    System.out.println(map.getClass());  //class java.util.HashMap
  }


}
