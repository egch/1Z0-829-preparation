package org.enricogiurin.ocp17.ch13.parallelstream;

import java.util.Arrays;
import java.util.List;


public class ParallelWordsCount {

  public static void main(String[] args) {
    new ParallelWordsCount().calculateTotalWordCount();
  }

  void calculateTotalWordCount() {

    List<String> documents = Arrays.asList(
        "This is a sample document.",
        "Another document for word counting.",
        "Java streams make this easy.",
        "Parallel processing is powerful."
    );

    // Calculate total word count in parallel

    long count = documents.parallelStream()
        .flatMap(line -> Arrays.stream(line.split("\\s+")))
        .reduce(0L, (cnt, word) -> cnt + 1, Long::sum);
    System.out.println(count);
  }

}
