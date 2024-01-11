package org.enricogiurin.ocp17.book.ch8.functionalinterface.primitive;

import java.util.List;
import java.util.function.ToIntFunction;

public class UsageOfToIntFunction {

  ToIntFunction<List<String>> toIntFunction = list -> list.size();

  public static void main(String[] args) {
    new UsageOfToIntFunction().anonymous();
  }

  void process() {
    int result = toIntFunction.applyAsInt(List.of("a", "ab", "abc"));
    System.out.println(result);
  }

  void processLambda() {
    ToIntFunction<String> toIntF = s -> s.length();
    List.of("a", "ab", "abc").stream()
        .mapToInt(toIntF)
        .forEach(System.out::println);
  }

  void anonymous() {
    ToIntFunction<String> toIntFnc = new ToIntFunction<>() {
      @Override
      public int applyAsInt(String value) {
        return value.length();
      }
    };
    int length = toIntFnc.applyAsInt("1234");
    System.out.println(length);
  }

}
