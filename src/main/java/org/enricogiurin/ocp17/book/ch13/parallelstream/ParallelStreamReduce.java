package org.enricogiurin.ocp17.book.ch13.parallelstream;


import java.util.stream.LongStream;
import java.util.stream.Stream;

public class ParallelStreamReduce {

  public static void main(String[] args) {
    new ParallelStreamReduce().factorial(10);
  }

  void reduce() {
    Stream<Character> stream = Stream.of('e', 'n', 'r', 'i', 'c', 'o');
    String word = stream.parallel()
        .reduce("",
            (String s, Character c) -> s + c,
            (String s1, String s2) -> s1 + s2);
    System.out.println(word);
  }

  void factorial(long n) {
    long reduce = LongStream.rangeClosed(1, n)
        .parallel() // Enable parallel processing
        .boxed()
        .reduce(
            1L,              // Identity value
            (x, y) -> x * y, // Accumulator function
            (x, y) -> x * y  // Combiner function (for parallel processing)
        );
    System.out.println(reduce);
  }


}
