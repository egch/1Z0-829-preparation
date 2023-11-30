package org.enricogiurin.ocp17.book.ch13.parallelstream;

import java.util.stream.IntStream;
import java.util.stream.LongStream;

public class PredictableParallelStream {

  public static void main(String[] args) {
    new PredictableParallelStream().unpredictable_fixed();
  }

  /**
   * Associativity of the Accumulator Function: The accumulator function passed to the reduce
   * operation must be associative.
   * <p>
   * Identity Value for the Accumulator: The identity value used as the initial value for the
   * accumulator must be a true identity for the accumulator function. An identity value ID should
   * satisfy the property that for any value a, accumulator(ID, a) is equal to a.
   */
  void predictable() {
    IntStream intStream = IntStream.rangeClosed(1, 100);

    // Associative accumulator function (addition) and identity value (0)
    int sum = intStream
        .boxed()
        .parallel()
        .reduce(0, (a, b) -> a + b, Integer::sum);

    //The result will always be the same
    System.out.println(sum); //5050
  }


  //https://levelup.gitconnected.com/be-careful-with-java-parallel-streams-3ed0fd70c3d0
  //result on my machine is 40975790625000. That’s doesn’t match with 2622450600.
  void unpredictable() {
    long result = LongStream.of(2, 53, 17, 21, 11, 42, 30)
        .parallel()
        .reduce(5, (acc, next) -> acc * next);
    System.out.println(result);
  }

  void unpredictable_fixed() {
    long res = LongStream.of(2, 53, 17, 21, 11, 42, 30)
        .parallel()
        .reduce(1, (acc, next) -> acc * next) * 5;
    System.out.println(res);
  }

}
