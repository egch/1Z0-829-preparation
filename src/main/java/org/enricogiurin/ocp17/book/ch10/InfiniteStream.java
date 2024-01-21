package org.enricogiurin.ocp17.book.ch10;

import java.util.Random;
import java.util.function.Predicate;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class InfiniteStream {

  public static void main(String[] args) {
    new InfiniteStream().iterateWithPredicate();
  }

  void infiniteStream() {
    Stream.generate(() -> "")
        .filter(s -> s.length() > 0)
        .limit(2)   //no matter the limit, we keep waiting to have elements not empty
        .forEach(System.out::print);
  }

  void iterate() {
    Predicate<String> predicate = s -> s.length() > 3;
    var stream = Stream.iterate("-",
        s -> !s.isEmpty(), (s) -> s + s);
    //Exception in thread "main" java.lang.OutOfMemoryError: Overflow: String length out of range
    long count = stream.peek(s -> System.out.println(s.length()))
        .count();
    //max length string before Overflow: 1073741824 -> double is almost the max length

    //Therefore, the maximum length of String in Java is 0 to 2147483647.
    // So, we can have a String with the length of 2,147,483,647 characters, theoretically.
  }

  void iterateWithPredicate() {
    Random random = new Random();
    //uses iterate with 3 args
    Stream<Integer> stream = Stream.iterate(0,
        n -> n < 90,
        n -> random.nextInt(100));
    long count = stream
        .peek(System.out::println)
        .count();
    System.out.println(count);
  }

  void iteratePostIncrement() {
    Stream.iterate(1, x -> x++)  //the postincrement is ignored
        .limit(10)
        .forEach(System.out::println); //prints 1....1

    Stream.iterate(1, x -> ++x)  //the pre-increment is taken into account
        .limit(10)
        .forEach(System.out::println); //prints 1....10
  }

  void concatenateInfiniteStream() {
    var odds = IntStream.iterate(1, a -> a + 2);
    var evens = IntStream.iterate(2, a -> a + 2);
    //since we have limit 3 only the first 3 elements from odds are taken
    var sum = IntStream.concat(odds, evens)
        .peek(System.out::println) //1...3...5
        .limit(3).sum();
    System.out.print(sum);
  }

  //this is not infinite as we just need the first element
  void generateFindFirst() {
    String result = Stream.generate(() -> "a")
        .findFirst()
        .orElse("nothing");
    System.out.println(result);
  }

  //this is not infinite as we just need any element
  void generateFindAny() {
    String result = Stream.generate(() -> "a")
        .findAny()
        .orElse("nothing");
    System.out.println(result);
  }


}
