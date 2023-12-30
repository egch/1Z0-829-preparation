package org.enricogiurin.ocp17.book.ch13.parallelstream;

import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ConcurrentSkipListMap;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ParallelCollector {

  public static void main(String[] args) {
    new ParallelCollector().groupingByConcurrentRandomString();
  }

  void concurrentMap() {
    Stream<String> allFruits = allFruits();
    ConcurrentMap<Integer, String> map = allFruits.parallel()
        .collect(Collectors.toConcurrentMap(String::length,
            k -> k,
            (String s1, String s2) -> s1 + "," + s2));
    //{4=Kiwi, 5=Mango,Apple, 6=Grapes,Orange,Banana, 9=Blueberry,Pineapple, 10=Watermelon,Strawberry}
    System.out.println(map);
  }

  void groupingBy() {
    Function<String, Integer> countVowels = s -> {
      int cnt = 0;
      for (char c : s.toLowerCase().toCharArray()) {
        if (c == 'a' || c == 'i' || c == 'u' || c == 'o' || c == 'e') {
          cnt++;
        }
      }
      return cnt;

    };
    Stream<String> allFruits = allFruits();
    ConcurrentMap<Integer, List<String>> map = allFruits.parallel()
        .collect(Collectors.groupingByConcurrent(countVowels));
    //{2=[Grapes, Mango, Apple, Strawberry, Kiwi], 3=[Blueberry, Banana, Orange], 4=[Watermelon, Pineapple]}
    System.out.println(map);
  }

  void groupingByConcurrentRandomString() {
    Random random = new Random();
    Stream<String> stream = Stream.generate(() -> "" + random.nextInt());
    //collect a set of 1_000 random int
    Set<String> set = stream
        .limit(1_000)
        .collect(Collectors.toSet());

    //I group them based on the length
    ConcurrentSkipListMap<Integer, List<String>> map = set.parallelStream()
        .collect(Collectors.groupingByConcurrent(
            s -> s.length(),   //how to group data
            ConcurrentSkipListMap::new,  //the map used to contain the result
            Collectors.toList()));   //how to group values with the same key
    System.out.println(map);
  }

  Stream<String> allFruits() {
    return Stream.of(
        "Apple", "Banana", "Orange", "Strawberry", "Pineapple",
        "Mango", "Grapes", "Watermelon", "Kiwi", "Blueberry"
    );
  }

}
