package org.enricogiurin.ocp17.book.ch8.functionalinterface.jdk;

import java.util.function.BiPredicate;

public class UsageOfBiPredicate {

  public static void main(String[] args) {
    new UsageOfBiPredicate().anonymous();
  }

  void fi() {
    BiPredicate<String, String> contains = (s1, s2) -> s1.contains(s2);
    boolean test = contains.test("hello", "he");
    System.out.println(test);
  }

  void mr() {
    BiPredicate<String, String> isEqualIgnoreCase = String::equalsIgnoreCase;
    boolean test = isEqualIgnoreCase.test("hello", "Hello");
    System.out.println(test);
  }

  void anonymous() {
    BiPredicate<Integer, Integer> isLower = new BiPredicate<>() {
      @Override
      public boolean test(Integer n1, Integer n2) {
        return n1 < n2;
      }
    };
    boolean test = isLower.test(5, 3);
    System.out.println(test);
  }

}
