package org.enricogiurin.ocp17.book.ch1;

public class Various {

  public static void main(String[] args) {
    new Various().checkEquals();
  }

  void checkEquals() {
    String s1 = "a";
    String s2 = "b";
    //First the value of 's1' is evaluated
    // before the method is called, the operands are evaluated, so s1 becomes "b".
    // So "a".equals("b") is false.
    boolean equals = s1.equals(s1 = s2);
    System.out.println(equals); //false
  }

}
