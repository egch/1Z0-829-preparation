package org.enricogiurin.ocp17.book.ch10;

import java.util.List;

public class ReduceToCountTotLengthOfString {

  public static void main(String[] args) {
    new ReduceToCountTotLengthOfString().reduceParallel();
  }

  void reduce() {
    List<String> list = List.of("a", "ab", "abc", "abcd");
    Integer totChars = list.stream()
        .reduce(0,
            (Integer partial, String s) -> s.length() + partial,
            Integer::sum);
    System.out.println(totChars);  //10 - 1+2+3+4
  }

  void reduceParallel() {
    List<String> list = List.of("a", "ab", "abc", "abcd");
    //I can use parallel stream because the accumulator and the combiner are associative

    //note that in the accumulator the 2nd parameter is the same as the original stream
    Integer totChars = list.parallelStream()
        .reduce(0,
            (Integer partial, String s) -> s.length() + partial,
            Integer::sum);
    System.out.println(totChars);  //10 - 1+2+3+4
  }

}
