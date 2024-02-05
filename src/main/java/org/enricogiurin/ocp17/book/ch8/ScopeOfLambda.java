package org.enricogiurin.ocp17.book.ch8;

import java.util.List;
import java.util.function.Predicate;

public class ScopeOfLambda {

  public void remove(List<Character> chars) {
    char end = 'z';
    //char c = 'a';  // DOES NOT COMPILE
    Predicate<Character> predicate = c -> {
      char start = 'a';
      return start <= c && c <= end;
    };  //mind the semi-colon
    //I can re-define c here
    //Since the scope of start and c is within the lambda, the variables can be declared
    // or updated after it without issue,
    char c = 'z';

  }

}
