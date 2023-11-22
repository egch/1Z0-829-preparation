package org.enricogiurin.ocp17.book.ch10;

import java.util.List;

public class ExampleWithReduce {

  public static void main(String[] args) {
    new ExampleWithReduce().consistent();
  }

  public String concat1(List<String> values) {
    return values.parallelStream()
        .reduce("a",
            (x, y) -> x + y,
            String::concat);
  }

  public String concat2(List<String> values) {
    return values.parallelStream()
        .reduce((w, z) -> z + w).get();
  }

  void usage() {
    List<String> names = List.of("Enrico", "John");
    String s1 = concat1(names);
    System.out.println(s1); //aEnricoaJohn
    String s2 = concat2(names);
    System.out.println(s2);  //MarioEnrico
  }

  void consistent() {
    var data = List.of(1, 2, 3);
    int f = data.parallelStream()
        .reduce(1,
            (a, b) -> {
              System.out.println("[accumulator] a:" + a + " - b:" + b);
              return a + b;
            },
            (a, b) -> {
              System.out.println("[combiner] a:" + a + " - b:" + b);
              return a + b;
            });
    System.out.println(f);
  }

}
