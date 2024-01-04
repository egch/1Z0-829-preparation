package org.enricogiurin.ocp17.book.ch10.collectors;


import static org.enricogiurin.ocp17.book.ch10.StreamUtils.fruitStream;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class UsageOfCollectors {

  public static void main(String[] args) {
    new UsageOfCollectors().joining();
  }

  void joining() {
    List<String> people = List.of("John", "Mark", "Brad", "Enrico");

    String collect = people.stream()
        .collect(Collectors.joining(", "));
    System.out.println(collect);  //John, Mark, Brad, Enrico
    //joining with prefix and suffix

    String result = people.stream()
        .collect(Collectors.joining(", ", "People: ", ""));
    System.out.println(result);  //People: John, Mark, Brad, Enrico
  }

  void averagingInt() {
    Stream<String> fruitStream = fruitStream();
    //average length of the string in the stream
    Double average = fruitStream.collect(Collectors.averagingInt(value -> value.length()));
    System.out.println("average: " + average); //4.9
  }

}
