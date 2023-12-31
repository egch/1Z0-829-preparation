package org.enricogiurin.ocp17.book.ch10;

import java.util.Optional;
import java.util.stream.Stream;

public class UsageOfStream {

  public static void main(String[] args) {
    new UsageOfStream().reAssignStream();
  }

  void infiniteRandom() {
    //infinite loop of random number
    Stream<Double> doubleStream = Stream.generate(Math::random);
    doubleStream.takeWhile(aDouble -> aDouble > 0.1).forEach(System.out::println);
  }

  void min() {
    Stream<String> boys = Stream.of("enrico", "luca", "fabio");
    //min() requires a Comparator
    Optional<String> min = boys.min((o1, o2) -> o1.length() - o2.length());
    min.ifPresent(mv -> System.out.println(mv));
  }

  void reduce() {
    Stream<String> stream = Stream.of("v", "i", "v", "a");
    String result = stream.reduce("", (s1, s2) -> s1 + s2);
    System.out.println(result);
  }

  void reduceMultiply() {
    Stream<Integer> integerStream = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
    Integer result = integerStream.peek(System.out::println).reduce(1, (n1, n2) -> n1 * n2);
    System.out.println(result);
  }

  void reAssignStream() {
    Stream<Integer> s1 = Stream.of(8, 2);
    Stream<Integer> s2 = Stream.of(10, 20);
    s2 = s1.filter(n -> n > 4);
    s1 = s2.filter(n -> n < 1);
    System.out.println(s1);
    System.out.println(s2);
    System.out.println(s1 == s2);
    System.out.println(s1.count());
    //Exception in thread "main" java.lang.IllegalStateException: stream has already been operated upon or closed
    System.out.println(s2.count());
  }


}
