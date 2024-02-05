package org.enricogiurin.ocp17.book.ch8.functionalinterface.jdk.primitive;

import java.util.function.ToIntBiFunction;

public class UsageOfToIntBiFunction {

  public static void main(String[] args) {
    new UsageOfToIntBiFunction().fi();
  }

  void fi() {
    ToIntBiFunction<String, String> maxLength = (s1, s2) -> Math.max(s1.length(), s2.length());
    int max = maxLength.applyAsInt("hello", "hi");
    System.out.println(max); //5
  }

  void anonymous() {
    ToIntBiFunction<String, String> minLenght = new ToIntBiFunction<>() {
      @Override
      public int applyAsInt(String s1, String s2) {
        return Math.min(s1.length(), s2.length());
      }
    };
    int min = minLenght.applyAsInt("1234", "");
    System.out.println(min);  //0
  }
}
