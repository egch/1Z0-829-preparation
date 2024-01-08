package org.enricogiurin.ocp17.book.ch10;

import java.util.Arrays;
import java.util.List;
import java.util.Spliterator;
import java.util.stream.Stream;

public class UsageOfSpliterator {

  public static void main(String[] args) {
    new UsageOfSpliterator().repeatedCallsToSpliterator();
  }

  void use() {
    List<String> words = Arrays.asList("Hello", "World", "Java", "Programming");
    //here is called on Collection
    Spliterator<String> spliterator = words.spliterator();
    Spliterator<String> si1 = spliterator.trySplit();
    boolean isThere = si1.tryAdvance(System.out::println);  //Hello
    isThere = si1.tryAdvance(System.out::println);  //world
    //even if tryAdvance returns false you can keep calling
    isThere = si1.tryAdvance(System.out::println);  //empty
    System.out.println(isThere);  //false
  }

  void forEachRemaining() {
    List<String> words = Arrays.asList("Hello", "World", "Java", "Programming");
    //here is called on Collection
    Spliterator<String> spliterator = words.spliterator();
    Spliterator<String> firstHalf = spliterator.trySplit();
    while (firstHalf.tryAdvance(System.out::println)) {
    }  //Hello World
    System.out.println();
    spliterator.forEachRemaining(System.out::println);  //Java Programming

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

  void justSpliterator() {
    //in this method we only all spliterator(), we do not call trySplit()
    //so at the end is just a normal stream
    Stream<String> fruitStream = Stream.of("Apple", "Banana", "Orange", "Grape", "Kiwi");
    //here applied on the stream
    Spliterator<String> spliterator = fruitStream.spliterator();
    //Apple Banana Orange Grape Kiwi
    spliterator.forEachRemaining(s -> System.out.print(s+" "));
  }

  void infiniteStream() {
    var spliterator = Stream.generate(() -> "x")
        .spliterator();

    spliterator.tryAdvance(System.out::print); //x
    var split = spliterator.trySplit();
    split.tryAdvance(System.out::print); //x
  }

  void shareToys() {
        record Toy(String name){ }

        var toys = Stream.of(
               new Toy("Toy A"),
               new Toy("Toy B"),
               new Toy("Toy C"),
               new Toy("Toy D"));

        var spliterator = toys.spliterator();
        var batch = spliterator.trySplit();  //batch contains the first two: Toy A, Toy B

        var more = batch.tryAdvance(x -> {}); //we remove Toy A from batch but it still contains Toy B
        System.out.println(more);  //true - as it still contains Toy B
        spliterator.tryAdvance(System.out::println); //here we print the first of the 2nd group: Toy C
  }

  void repeatedCallsToSpliterator() {
    List<String> list = List.of("a", "b", "c", "d");
    Spliterator<String> spliterator = list.spliterator();
    Spliterator<String> siFirst = spliterator.trySplit();

    //the following 3 calls are meaningless since siFirst has already been split off.
    Spliterator<String> siSecond = spliterator.trySplit();
    Spliterator<String> siThird = spliterator.trySplit();

    //a, b
    siFirst.forEachRemaining(s -> System.out.println(s));
  }

}
