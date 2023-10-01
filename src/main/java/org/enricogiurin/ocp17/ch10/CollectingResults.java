package org.enricogiurin.ocp17.ch10;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CollectingResults {

  public static void main(String[] args) {
    new CollectingResults().groupingByBoolean();
  }

  void averagingInt() {
    Stream<String> fruitStream = fruitStream();
    Double average = fruitStream.collect(Collectors.averagingInt(value -> value.length()));
    System.out.println("average: "+average); //4.9
  }

  void map() {
    Stream<String> fruitStream = fruitStream();
    Map<Integer, String> map = fruitStream.collect(
        Collectors.toMap(String::length, f -> f, (f1, f2) -> f1 + ", " + f2));
    System.out.println(map);  //{4=Kiwi, Pear, Lime, 5=Apple, Grape, Peach, Mango, Lemon, 6=Banana, Orange}
    System.out.println(map.getClass());  //class java.util.TreeMap
  }

  void treeMap() {
    Stream<String> fruitStream = fruitStream();
    TreeMap<Integer, String> map = fruitStream.collect(
        Collectors.toMap(String::length,
            f -> f,
            (f1, f2) -> f1 + ", " + f2,
            TreeMap::new));

    System.out.println(map);  //{4=Kiwi, Pear, Lime, 5=Apple, Grape, Peach, Mango, Lemon, 6=Banana, Orange}
    System.out.println(map.getClass());  //class java.util.HashMap
  }

  void groupingBy() {
    Stream<String> fruitStream = fruitStream();
    Map<Integer, List<String>> map = fruitStream.collect(Collectors.groupingBy(String::length));
    System.out.println(map);  //{4=[Kiwi, Pear, Lime], 5=[Apple, Grape, Peach, Mango, Lemon], 6=[Orange, Banana]}
  }

  void groupingByBoolean() {
    Stream<String> fruitStream = fruitStream();
    Map<Boolean, List<String>> map = fruitStream.collect(Collectors.groupingBy(s->s.startsWith("K")));
    System.out.println(map);  //{4=[Kiwi, Pear, Lime], 5=[Apple, Grape, Peach, Mango, Lemon], 6=[Orange, Banana]}

  }

  void groupingBySet() {
    Stream<String> fruitStream = fruitStream();
    Map<Integer, Set<String>> map = fruitStream.collect(Collectors.groupingBy(String::length,
        Collectors.toSet()));
    System.out.println(map);  //{4=[Lime, Kiwi, Pear], 5=[Apple, Grape, Peach, Mango, Lemon], 6=[Orange, Banana]}
  }

  void partitioningBy() {
    Stream<String> fruitStream = fruitStream();
    Map<Boolean, List<String>> map = fruitStream.collect(
        Collectors.partitioningBy(f -> f.length() < 5));
    System.out.println(map);
    //{false=[Orange, Apple, Banana, Grape, Peach, Mango, Lemon], true=[Kiwi, Pear, Lime]}

  }

  void partitioningByCounting() {
    Stream<String> fruitStream = fruitStream();
    Map<Boolean, Long> map = fruitStream.collect(
        Collectors.partitioningBy(f -> f.length() < 5,
            Collectors.counting()));
    System.out.println(map);
    //{false=7, true=3}

  }

  private Stream<String> fruitStream() {
    return Stream.of("Orange", "Apple", "Banana", "Grape", "Kiwi",
        "Pear", "Peach", "Mango", "Lemon", "Lime");
  }


}
