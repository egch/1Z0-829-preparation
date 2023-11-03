package org.enricogiurin.ocp17.book.ch8;

import java.util.List;
import java.util.function.Predicate;

public class Questions {

  public void remove(List<Character> chars) {
    char end = 'z';

    //but I cannot define it here
    // char c = 'x';  //does not compile
    Predicate<Character> predicate = c -> {
      char start = 'a';
      return start <= c && c <= end;
    };
    char c = 'x';
    char start = 'a';
// INSERT LINE HERE
  }

  void scope() {
    //before I cannot
    //int x = 4;
    if (true) {
      int x = 5;
    }

    //here the x in the if is no longer in scope
    //so I can define a variable with the same name
    int x = 5;
  }


  void assignLambdaToVar() {
    //here the The compiler does not have enough information to determine they are of type Predicate<String>.
    //var predicate = (s) -> s.isEmpty();

    //Cannot infer type: lambda expression requires an explicit target type

    //var predicate = (String s) -> s.isEmpty();

  }

  void finalParameter() {
    //it's possible to use final!
    Predicate<String> predicate = (final String s) -> false;
  }


}
