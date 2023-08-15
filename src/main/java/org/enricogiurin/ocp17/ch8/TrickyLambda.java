package org.enricogiurin.ocp17.ch8;

import java.util.function.Function;

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

}
