package org.enricogiurin.ocp17.book.ch10;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CollectingResults {

  public static void main(String[] args) {
    new CollectingResults().summingInt();
  }

  void averagingInt() {
    Stream<String> fruitStream = fruitStream();
    Double average = fruitStream.collect(Collectors.averagingInt(value -> value.length()));
    System.out.println("average: " + average); //4.9
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



  void partitioningBy() {
    Stream<String> fruitStream = fruitStream();
    Map<Boolean, List<String>> map = fruitStream.collect(
        Collectors.partitioningBy(f -> f.length() < 5));
    System.out.println(map);
    //{false=[Orange, Apple, Banana, Grape, Peach, Mango, Lemon], true=[Kiwi, Pear, Lime]}

  }

  void summingInt() {
    record Data(String name, int score){}
    Stream<Data> scores = Stream.of(
        new Data("John", 1),
        new Data("Robert", 8),
        new Data("John", 9),
        new Data("Robert", 7),
        new Data("Jack", 6)
    );
    Map<String, Integer> map = scores.collect(
        Collectors.groupingBy(Data::name, Collectors.summingInt(Data::score)));
    map.forEach(((k, v)-> System.out.println(k+": "+v)));
    /*
    Robert: 15
    John: 10
    Jack: 6
     */
  }

  void partitioningByCounting() {
    Stream<String> fruitStream = fruitStream();
    Map<Boolean, Long> map = fruitStream.collect(
        Collectors.partitioningBy(f -> f.length() < 5,
            Collectors.counting()));
    System.out.println(map);
    //{false=7, true=3}

  }

  //note that Banana is present twice
  private Stream<String> fruitStream() {
    return Stream.of("Orange", "Apple", "Banana", "Grape", "Kiwi",
        "Pear", "Peach", "Mango", "Lemon", "Lime", "Banana");
  }


}
