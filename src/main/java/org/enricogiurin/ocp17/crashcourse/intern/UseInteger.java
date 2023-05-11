package org.enricogiurin.ocp17.crashcourse.intern;

public class UseInteger {
  public static void main(String[] args) {
    // autoboxed Integer in range of byte (-128 +127) are pooled
//    Integer i1 = 99;
//    Integer i2 = 99;
    Integer i1 = Integer.valueOf(99); // this is what autoboxing creates
//    Integer i1 = new Integer(99); // this is deprecated DON'T use constructor
    Integer i2 = 99;
    Integer i3 = 100;
    System.out.println(i1 == i2);
    System.out.println(i1 == i3);
  }
}
