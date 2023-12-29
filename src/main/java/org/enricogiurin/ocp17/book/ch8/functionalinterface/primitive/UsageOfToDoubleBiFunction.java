package org.enricogiurin.ocp17.book.ch8.functionalinterface.primitive;

import java.util.function.ToDoubleBiFunction;

public class UsageOfToDoubleBiFunction {

  public static void main(String[] args) {
    new UsageOfToDoubleBiFunction().average();
  }

  void usage() {
    //Incompatible parameter types in lambda expression: expected Double but found double
    //ToDoubleBiFunction<Double, Double> toDoubleBiFunction = (double y, double z) -> y+z;  //does not compile

    //valid as a long can be cast to a double, not the other way around
    ToDoubleBiFunction<Integer, Integer> toDoubleBiFunction = (h, i) -> (long) h;
    double result = toDoubleBiFunction.applyAsDouble(4, 5);
    System.out.println(result); //4.0
  }

  void average() {
    ToDoubleBiFunction<Integer, Integer> toDoubleBiFunction = (Integer points, Integer races) ->
        (double) points / races;
    double result = toDoubleBiFunction.applyAsDouble(56, 12);
    System.out.println(result);
  }

}
