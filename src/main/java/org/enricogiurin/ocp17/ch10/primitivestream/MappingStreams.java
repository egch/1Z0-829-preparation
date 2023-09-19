package org.enricogiurin.ocp17.ch10.primitivestream;

import java.util.OptionalDouble;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class MappingStreams {

  public static void main(String[] args) {
    new MappingStreams().mapToInt();
  }
  void mapToInt() {
    Stream<String> fruitStream = Stream.of("Apple", "Banana", "Orange", "Grape", "Kiwi");
    //I mapped them to an IntStream
    IntStream intStream = fruitStream.mapToInt(value -> value.length());
    OptionalDouble optionalDouble = intStream.average();
    //average length of fruits is: 5.2
    optionalDouble.ifPresent(d-> System.out.println("average length of fruits is: "+d));
  }

  void mapToObj() {
    //these two are equivalent.
    Stream<Integer> intStream = IntStream.rangeClosed(1, 10)
        .mapToObj(n -> n);

    intStream = IntStream.rangeClosed(1, 10)
        .boxed();
  }

}
