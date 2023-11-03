package org.enricogiurin.ocp17.book.ch2;

public class CompoundAssignmentOperators {

  public static void main(String[] args) {
    new CompoundAssignmentOperators().trickyAssignment();
  }

  void trickyCompound() {
    long quantity = 10L;
    int cost = 5;
    //this does not compile as I would need long LHS
    //cost = cost * quantity;
    //this works with compound operator
    cost *= quantity;
    System.out.println(cost); //50
  }

  void assignment() {
    long quantity;
    long number = (quantity = 3L);
    System.out.println(number);  //3
    System.out.println(quantity); //3
  }

  void trickyAssignment() {
    boolean a = false;
    //this condition is true as to a is assigned the value true;
    if (a = true) {
      System.out.println("tricky one");
    }
  }

}
