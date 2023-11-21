package org.enricogiurin.ocp17.book.ch8.functionalinterface.primitive;

import java.util.List;
import java.util.function.ToIntFunction;

public class UseOfToIntFunction {

  ToIntFunction<List<String>> toIntFunction = list -> list.size();

  public static void main(String[] args) {
    new UseOfToIntFunction().processLambda();
  }

  void process() {
    int result = toIntFunction.applyAsInt(List.of("a", "ab", "abc"));
    System.out.println(result);
  }

  void processLambda() {
    List.of("a", "ab", "abc").stream()
        .mapToInt(s -> s.length())
        .forEach(System.out::println);
  }

}
