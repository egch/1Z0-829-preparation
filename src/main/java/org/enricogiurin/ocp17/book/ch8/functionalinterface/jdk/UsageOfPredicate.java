package org.enricogiurin.ocp17.book.ch8.functionalinterface.jdk;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.IntStream;

public class UsageOfPredicate {

  public static void main(String[] args) {
    new UsageOfPredicate().or();
  }

  void predicate() {
    Predicate<String> predicateString = x -> true;
    Predicate<String> predicateWIthVar = (var x) -> true;
  }

  void and() {
    Predicate<String> p1 = s -> s.startsWith("a");
    Predicate<String> p2 = s -> s.length() > 2;
    Predicate<String> global = p1.and(p2);
    List<String> list = List.of("assa", "jfkjdkfj", "aa");

    list.stream()
        .filter(global)
        .forEach(System.out::println);  //assa
  }

  void or() {
    Predicate<Integer> p1 = n -> n % 2 == 0;
    Predicate<Integer> p2 = n -> n > 10;
    Predicate<Integer> global = p1.or(p2);
    IntStream.rangeClosed(5, 13)
        .boxed()
        .filter(global)
        .forEach(System.out::print);  //6 8 10 11 12 13
  }
}
