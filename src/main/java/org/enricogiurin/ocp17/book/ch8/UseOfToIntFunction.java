package org.enricogiurin.ocp17.book.ch8;

import java.util.List;
import java.util.function.ToIntFunction;

public class UseOfToIntFunction {

  public static void main(String[] args) {
    new UseOfToIntFunction().process();
  }
  ToIntFunction<List<String>> toIntFunction = list -> list.size();

  void process() {
    int result = toIntFunction.applyAsInt(List.of("a", "ab", "abc"));
    System.out.println(result);

  }

}
