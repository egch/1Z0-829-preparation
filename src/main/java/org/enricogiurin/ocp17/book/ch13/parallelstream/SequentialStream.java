package org.enricogiurin.ocp17.book.ch13.parallelstream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class SequentialStream {

  public static void main(String[] args) {
    new SequentialStream().sequential();
  }

  void sequential() {
    List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

    // Convert the parallel stream to a sequential stream
    List<Integer> sequentialResult = numbers.parallelStream()
        .sequential()  // This makes the stream sequential
        .collect(Collectors.toList());
    System.out.println("Sequential Stream Result: " + sequentialResult);
  }


}
