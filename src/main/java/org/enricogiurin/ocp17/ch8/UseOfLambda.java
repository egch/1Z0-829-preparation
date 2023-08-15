package org.enricogiurin.ocp17.ch8;

import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class UseOfLambda {

  void withFinal() {
    //final is allowed
    Consumer<String> stringConsumer = (final String s) -> {
    };
  }

  void throwsException() {
    BiConsumer handler = (x, y) -> new RuntimeException();

  }

  void variablesScope() {
    char end = 'z';
    //start is present in lambda
    //char start = 'a';
    Predicate<Character> predicate = c -> {
      char start = 'a';
      return start <= c && c <= end;
    };
  }


}

