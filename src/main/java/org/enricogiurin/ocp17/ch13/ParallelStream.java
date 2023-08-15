package org.enricogiurin.ocp17.ch13;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class ParallelStream {

  public static void main(String[] args) {
    //new ParallelStream().calculate();
    //new ParallelStream().calculateParallel();
    //   new ParallelStream().calculateParallelOrdered();
    new ParallelStream().printSize();
  }

  void calculate() {
    long start = System.currentTimeMillis();
    List<Integer> list = List.of(1, 2, 3, 4, 5);
    list.stream()
        .map(this::pow2)
        .forEach(s -> System.out.print(s + " "));
    System.out.println();
    long time = System.currentTimeMillis() - start;
    System.out.println("time taken: " + time + " seconds");
  }

  //faster but order not guaranteed
/*    25 16 4 9 1
    time taken: 1026 seconds*/
  void calculateParallel() {
    long start = System.currentTimeMillis();
    List<Integer> list = List.of(1, 2, 3, 4, 5);
    list.parallelStream()
        .map(this::pow2)
        .forEach(s -> System.out.print(s + " "));
    System.out.println();
    long time = System.currentTimeMillis() - start;
    System.out.println("time taken: " + time + " seconds");
  }

  //faster and order guaranteed
  //1 4 9 16 25
  //time taken: 1019 seconds
  void calculateParallelOrdered() {
    long start = System.currentTimeMillis();
    List<Integer> list = List.of(1, 2, 3, 4, 5);
    list.parallelStream()
        .map(this::pow2)
        .forEachOrdered(s -> System.out.print(s + " "));
    System.out.println();
    long time = System.currentTimeMillis() - start;
    System.out.println("time taken: " + time + " seconds");
  }

  int pow2(int value) {
    try {
      Thread.sleep(1000);
    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    }
    return value * value;
  }

  //The forEachOrdered() method will process the elements in the order in which they are stored in the stream
  void forEachOrdered() {
    var data = List.of(2, 5, 1, 9, 8);
    data.stream().parallel()
        .mapToInt(s -> s)
        //order cannot be determined
        // .peek(System.out::print)
        //original ordered: 2,5,1,9,8

        .forEachOrdered(System.out::print);
    // .forEach(System.out::print);

  }


  void printSize() {
    List<Integer> data1 = new ArrayList<>();
    List<Integer> data2 = new ArrayList<>();
    List<Integer> data3 = new ArrayList<>();

    IntStream.range(0, 100).parallel().forEach(s -> data1.add(s));
    IntStream.range(0, 100).parallel().forEachOrdered(s -> data2.add(s));  //with this I have 100
    IntStream.range(0, 100).parallel().forEachOrdered(s -> {
      synchronized (data3) {
        data3.add(s);
      }
    });
    System.out.println(data1.size());  //95 (can be different)
    System.out.println(data2.size()); //100
    System.out.println(data3.size()); //100
  }
}
