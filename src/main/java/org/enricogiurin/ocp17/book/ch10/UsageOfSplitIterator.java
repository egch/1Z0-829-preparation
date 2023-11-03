package org.enricogiurin.ocp17.book.ch10;

import java.util.Arrays;
import java.util.List;
import java.util.Spliterator;
import java.util.stream.Stream;

public class UsageOfSplitIterator {

  public static void main(String[] args) {
    new UsageOfSplitIterator().infiniteStream();
  }

  void use() {
    List<String> words = Arrays.asList("Hello", "World", "Java", "Programming");
    //here applied on the collection
    Spliterator<String> spliterator = words.spliterator();
    //half of data
    Spliterator<String> spliterator1 = spliterator.trySplit();
    spliterator1.forEachRemaining(System.out::println); //hello world
    //spliterator1.forEachRemaining(System.out::println); //world
    System.out.println("-----");

    //spliterator contains the remaining 2 elements: "Java", "Programming")
    spliterator.tryAdvance(System.out::println); // Prints "Java"
    spliterator.tryAdvance(System.out::println); // Prints "Programming"
  }

  void fruits() {
    Stream<String> fruitStream = Stream.of("Apple", "Banana", "Orange", "Grape", "Kiwi");
    //here applied on the stream
    Spliterator<String> spliterator = fruitStream.spliterator();
    Spliterator<String> spliteratorFirstHalf = spliterator.trySplit();
    spliteratorFirstHalf.forEachRemaining(s -> System.out.println(s));
    //Apple
    //Banana

    System.out.println("-----");
    //the remaining
    boolean status = spliterator.tryAdvance(System.out::println);//Orange
    status = spliterator.tryAdvance(System.out::println);  //Grape
    status = spliterator.tryAdvance(System.out::println);  //Kiwi

    System.out.println(status);  //true

    status = spliterator.tryAdvance(System.out::println);  //no more elements
    System.out.println(status);   //false

  }

  void infiniteStream() {
    var spliterator = Stream.generate(() -> "x")
        .spliterator();

    spliterator.tryAdvance(System.out::print); //x
    var split = spliterator.trySplit();
    split.tryAdvance(System.out::print); //x
  }
}
