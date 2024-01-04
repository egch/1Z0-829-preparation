package org.enricogiurin.ocp17.book.ch10;

import java.util.stream.Stream;

public class StreamUtils {

  //note that Banana is present twice
  public static Stream<String> fruitStream() {
    return Stream.of("Orange", "Apple", "Banana", "Grape", "Kiwi",
        "Pear", "Peach", "Mango", "Lemon", "Lime", "Banana");
  }
}
