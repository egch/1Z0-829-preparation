package org.enricogiurin.ocp17.book.ch8.functionalinterface;

import java.util.function.Predicate;

public class UsageOfPredicate {

  void predicate() {
    Predicate<String> predicateString = x -> true;
    Predicate<String> predicateWIthVar = (var x) -> true;
  }
}
