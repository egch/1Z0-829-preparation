package org.enricogiurin.ocp17.book.ch8;

import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class UsageOfLambda {

  void withFinal() {
    //final is allowed
    Consumer<String> stringConsumer = (final String s) -> {
    };
  }

  void throwsException() {
    BiConsumer<String, String> handler = (x, y) -> new RuntimeException();
  }

  void variableScope() {
    char end = 'z';
    //start is present in lambda
    //char start = 'a';
    Predicate<Character> predicate = c -> {
      char start = 'a';
      return start <= c && c <= end;
    };
  }

  void withVar() {
    //var is allowed
    Function<String, String> appendPrefix = (var s) -> "-" + s;
  }

  void withVarFinal() {
    //final var is allowed
    Function<String, String> appendPrefixFinal = (final var s) -> "-" + s;
  }


}

