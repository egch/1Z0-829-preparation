package org.enricogiurin.ocp17.book.ch13.parallelstream;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class ForEachOrdered {

  public static void main(String[] args) {
    ForEachOrdered instance = new ForEachOrdered();
    //instance.forEachOrdered();
    instance.forEachOrderedComplex();
  }


  void forEachOrdered() {
    //in this case, I will have always 100
    //as I use forEachOrdered
    List<Integer> data = new ArrayList<>();
    IntStream.range(0, 100)
        .parallel()
        .forEachOrdered(s -> {
              System.out.println("processing value: " + s);
              data.add(s);
            }
        );
    System.out.println(data.size());
  }

  //this method does not guarantee to have 100
  //as the collection is not synchro
  void forEach() {
    List<Integer> data = new ArrayList<>();
    IntStream.range(0, 100)
        .parallel()
        .forEach(s -> {
          //  System.out.println("processing value: "+s);
          data.add(s);
        });
    System.out.println(data.size());
  }

  void forEachOrdered2() {
    IntStream.of(2, 5, 7, 1)
        .parallel()
        //.peek(s-> System.out.print(s+" "))  //print in a random order
        //always print in the stream insertion order
        .forEachOrdered(s -> System.out.print(s + " ")); //2 5 7 1
  }

  void forEachOrderedComplex() {
    IntStream.of(2, 5, 7, 1)
        .parallel()
        .boxed()
        .map(n -> n + "#")
        //always print in the stream insertion order
        .forEachOrdered(s -> System.out.print(s + " ")); //2# 5# 7# 1#
  }

}
