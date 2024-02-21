package org.enricogiurin.ocp17.book.ch2;

public class UsageOfLogicalOperator {

  public static void main(String[] args) {
    new UsageOfLogicalOperator().exclusiveOr();
  }


  //XOR -> ^ (caret)
  void exclusiveOr() {
    boolean[] values = {false, true};
    for (boolean opA : values) {
      for (boolean opB : values) {
        boolean exclusiveOr = opA ^ opB;
        System.out.println(opA + " ^ " + opB + " is: " + exclusiveOr);
      }
    }
    //false ^ false is: false
    //false ^ true is: true
    //true ^ false is: true
    //true ^ true is: false
  }


}
