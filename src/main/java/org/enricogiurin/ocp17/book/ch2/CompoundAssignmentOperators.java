package org.enricogiurin.ocp17.book.ch2;

public class CompoundAssignmentOperators {

  public static void main(String[] args) {
    new CompoundAssignmentOperators().compoundIntLong();
  }

  void trickyCompound() {
    long quantity = 10L;
    int cost = 5;
    //this does not compile as I would need long LHS
    //cost = cost * quantity;  //DOES NOT COMPILE!
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

  void compoundIntLong() {
    int anInt =5;
    long aLong = 6;
    //DOES NOT COMPILE
    //int result = anInt + aLong;
    int result = anInt;
    //minor warning: Implicit cast from 'long' to 'int' in compound assignment can be lossy
    result +=aLong;
    System.out.println(result);  //11
  }

  void trickyAssignment() {
    boolean a = false;
    //this condition is true as to a is assigned the value true;
    if (a = true) {
      System.out.println("tricky one");
    }
  }

}
