package org.enricogiurin.ocp17.book.ch10.collectors;

import static org.enricogiurin.ocp17.book.ch10.StreamUtils.fruitStream;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CollectorsPartitioningBy {

  public static void main(String[] args) {
    new CollectorsPartitioningBy().partitioningByCounting();
  }

  void partitioningBy() {
    Stream<String> fruitStream = fruitStream();
    Map<Boolean, List<String>> map = fruitStream.collect(
        Collectors.partitioningBy(f -> f.length() < 5));
    System.out.println(map);
    //{false=[Orange, Apple, Banana, Grape, Peach, Mango, Lemon, Banana], true=[Kiwi, Pear, Lime]}
  }

  void partitioningBy2Arg() {
    Stream<String> fruitStream = fruitStream();
    Map<Boolean, Set<String>> map = fruitStream.collect(Collectors.partitioningBy(
        (String s) -> s.toLowerCase().startsWith("b"),
        Collectors.toSet()));
    //{false=[Lime, Apple, Kiwi, Pear, Grape, Peach, Mango, Orange, Lemon], true=[Banana]}
    System.out.println(map);
  }

  void partitioningByCounting() {
    Stream<String> fruitStream = fruitStream();
    Map<Boolean, Long> map = fruitStream.collect(
        Collectors.partitioningBy(f -> f.length() < 5,
            Collectors.counting()));
    System.out.println(map);
    //{false=8, true=3}

  }

}
