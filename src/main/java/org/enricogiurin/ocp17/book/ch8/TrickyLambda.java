package org.enricogiurin.ocp17.book.ch8;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class TrickyLambda {

  public static void main(String[] args) {
    TrickyLambda trickyLambda = new TrickyLambda();

    //Autoboxing works for collections, not inferring predicates.
    //incompatible parameter types in lambda expression: expected Integer but found int
    //trickyLambda.build((int x)->x>5);
    trickyLambda.build((Integer x) -> x > 5);  //this is valid
  }

  void build(Function<Integer, Boolean> function) {
    Boolean result = function.apply(5);
    System.out.println(result);
  }

  void trickyLambda() {
    //both compile...
    Consumer<Path> consumer = p -> Files.isDirectory(p);
    Predicate<Path> predicate = p -> Files.isDirectory(p);

    //but this does not compile
    //Consumer<Path> c2 = p -> true;



  }

}
