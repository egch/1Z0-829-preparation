package org.enricogiurin.ocp17.book.ch13.parallelstream;

import java.util.List;

public class ReduceParallelVsSequential {

  public static void main(String[] args) {
    ReduceParallelVsSequential instance = new ReduceParallelVsSequential();
    instance.parallel();
    instance.sequential();
    //in this case it produces the same result
    instance.sequentialWithNeutralIdentity();
    instance.parallelWithNeutralIdentity();
  }

  void parallel() {
    var data = List.of(1, 2, 3);
    int f = data.parallelStream()
        .reduce(1, (a, b) -> a + b, (a, b) -> a + b);
    System.out.println(f);  //9 -> (1+1)+ + (1+2) + (1+3)
  }

  void sequential() {
    var data = List.of(1, 2, 3);
    int f = data.stream()
        .reduce(1, (a, b) -> a + b, (a, b) -> a + b);
    System.out.println(f);  //7 -> 1+1+2+3
  }

  void parallelWithNeutralIdentity() {
    var data = List.of(1, 2, 3);
    int f = data.parallelStream()
        .reduce(0, (a, b) -> a + b, (a, b) -> a + b);
    System.out.println(f);  //6 -> (0+1)+ + (0+2) + (0+3)
  }

  void sequentialWithNeutralIdentity() {
    var data = List.of(1, 2, 3);
    int f = data.stream()
        .reduce(0, (a, b) -> a + b, (a, b) -> a + b);
    System.out.println(f);  //6 -> 0+1+2+3
  }

}
