package org.enricogiurin.ocp17.book.ch13.parallelstream;

import java.util.Set;
import java.util.concurrent.ConcurrentSkipListSet;
import java.util.stream.Stream;

public class ParallelStreamCollect {

  public static void main(String[] args) {
    new ParallelStreamCollect().collect_methodReference();
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

}
