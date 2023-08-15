package org.enricogiurin.ocp17.ch8;

import java.util.List;
import java.util.function.Predicate;

public class Questions {

  public void remove(List<Character> chars) {
    char end = 'z';
    Predicate<Character> predicate = c -> {
      char start = 'a';
      return start <= c && c <= end;
    };
    char c = 'x';
// INSERT LINE HERE
  }
}
