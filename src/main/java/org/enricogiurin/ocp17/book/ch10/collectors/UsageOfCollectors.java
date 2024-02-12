package org.enricogiurin.ocp17.book.ch10.collectors;


import static org.enricogiurin.ocp17.book.ch10.StreamUtils.fruitStream;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import org.enricogiurin.ocp17.various.helper.JarMockTest;

public class UsageOfCollectors {

  public static void main(String[] args) {
    new UsageOfCollectors().averagingIntWithRecord();
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

  void averagingIntWithRecord() {
    record Person(String name, int age) {

    }
    List<Person> persons = List.of(
        new Person("Alice", 25),
        new Person("Bob", 30),
        new Person("Charlie", 22),
        new Person("David", 28),
        new Person("Eve", 35)
    );
    double averageAge = persons.stream()
        .collect(Collectors.averagingInt(Person::age));

    //Average Age: 28.0
    System.out.println("Average Age: " + averageAge);
  }

  @JarMockTest
  void counting() {
    Long cnt = IntStream.rangeClosed(1, 10)
        .boxed()
        .collect(Collectors.counting());
    System.out.println(cnt); //10
  }

}
