package org.enricogiurin.ocp17.book.ch10;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CollectingResults {

  public static void main(String[] args) {
    new CollectingResults().groupingByInRecord();
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

  void groupingBy() {
    Stream<String> fruitStream = fruitStream();
    Map<Integer, List<String>> map = fruitStream.collect(Collectors.groupingBy(String::length));
    //{4=[Kiwi, Pear, Lime], 5=[Apple, Grape, Peach, Mango, Lemon], 6=[Orange, Banana, Banana]}
    //as you can see, Banana is present twice
    System.out.println(map);
  }

  void groupingBySet() {
    Stream<String> fruitStream = fruitStream();
    Map<Integer, Set<String>> map = fruitStream.collect(Collectors.groupingBy(String::length,
        Collectors.toSet()));
    //{4=[Lime, Kiwi, Pear], 5=[Apple, Grape, Peach, Mango, Lemon], 6=[Orange, Banana]}
    //as you can see, Banana is present only once!
    System.out.println(map);
  }

  void groupingByBoolean() {
    Stream<String> fruitStream = fruitStream();
    Map<Boolean, List<String>> map = fruitStream.collect(
        Collectors.groupingBy(s -> s.startsWith("K")));
    //{false=[Orange, Apple, Banana, Grape, Pear, Peach, Mango, Lemon, Lime, Banana], true=[Kiwi]}
    System.out.println(map);
  }

  void groupingByInRecord() {
    record Car(String name, int year) {

      @Override
      public String toString() {
        return name;
      }
    }

    var cars = new ArrayList<Car>();
    cars.add(new Car("Mustang", 1967));
    cars.add(new Car("Escort", 1975));
    cars.add(new Car("Thunderbird", 1967));

    //{1967=[Mustang, Thunderbird], 1975=[Escort]}
    TreeMap<Integer, List<Car>> map = cars.stream()
        .collect(Collectors.groupingBy(Car::year, TreeMap::new, Collectors.toList()));
    System.out.print(map);
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

  //note that Banana is present twice
  private Stream<String> fruitStream() {
    return Stream.of("Orange", "Apple", "Banana", "Grape", "Kiwi",
        "Pear", "Peach", "Mango", "Lemon", "Lime", "Banana");
  }


}
