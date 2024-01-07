package org.enricogiurin.ocp17.book.ch13.parallelstream;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ConcurrentSkipListSet;
import java.util.stream.Stream;

public class ParallelStreamCollect {

  public static void main(String[] args) {
    new ParallelStreamCollect().collect_toConcurrentMap();
  }

  void collect() {
    String source = "hfjehfjdhfjdhfjbnfejrwijcjscnvberurop4r0t9uijkdfnvkj";
    Stream<Character> characterStream = source.chars().mapToObj(n -> (char) n);
    ConcurrentSkipListSet<Character> set = characterStream.parallel()
        .collect(() -> new ConcurrentSkipListSet<>(),
            (ConcurrentSkipListSet<Character> characterSet, Character c) -> characterSet.add(c),
            (ConcurrentSkipListSet<Character> cs2, ConcurrentSkipListSet<Character> cs3) -> cs2.addAll(
                cs3));
    System.out.println("size: " + set.size()); //21
  }

  void collect_methodReference() {
    String source = "hfjehfjdhfjdhfjbnfejrwijcjscnvberurop4r0t9uijkdfnvkj";
    Stream<Character> characterStream = source.chars().mapToObj(n -> (char) n);
    ConcurrentSkipListSet<Character> set = characterStream.parallel()
        .collect(ConcurrentSkipListSet::new,
            Set::add,
            Set::addAll);
    System.out.println("size: " + set.size()); //21
  }


  void collect_toConcurrentMap() {
    //group these strings by size
    Stream<String> stream = Stream.of("0", "01", "03", "0", "123", "44");
    ConcurrentMap<Integer, Set<String>> groupedByLength = stream
        .parallel()
        .collect(
            ConcurrentHashMap::new,
            (map, str) -> {
              map.putIfAbsent(str.length(), new HashSet<>());
              map.get(str.length()).add(str);
            },
            (map1, map2) ->
            {
              //I need to have 2 identical maps
              //here I add all the element from map1 to map2
              for (var entry : map1.entrySet()) {
                map2.putIfAbsent(entry.getKey(), new HashSet<>());
                Set<String> set = map2.get(entry.getKey());
                set.addAll(entry.getValue());
              }

              //if the stream is not parallel, then the 2nd for is not needed
              //here I had all the element from map2 to map1
              for (var entry : map2.entrySet()) {
                map1.putIfAbsent(entry.getKey(), new HashSet<>());
                Set<String> set = map1.get(entry.getKey());
                set.addAll(entry.getValue());
              }
            }
        );
    //{1=[0], 2=[44, 01, 03], 3=[123]}
    System.out.println(groupedByLength);
  }

}
