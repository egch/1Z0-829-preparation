package org.enricogiurin.ocp17.book.ch2;

import org.enricogiurin.ocp17.various.helper.JarMockTest;

@JarMockTest
public class InfinityDivision {

  public static void main(String[] args) {
    new InfinityDivision().checkIsInfinite();
  }
  void aIntDivisionByZero(){
    int a=2, b=0;
    try {
      int c = a/b;
    }catch (Exception e){
      //  / by zero
      System.out.println(e.getMessage());
    }
  }

  void aFloatDivisionByZero() {
    Float f1 = 1.0F;
    Float f2 = 0.0F;
    Float result=null;
    try {
      result = f1 / f2;

    }catch (Exception e){
      //it does not go here!!!
      System.out.println(e.getMessage());
    }
    System.out.println(result.isInfinite());  //true
  }

  //same for Double
  void aDoubleDivisionByZero() {
    Double f1 = 1.0;
    Double f2 = 0.0;
    Double result=null;
    try {
      result = f1 / f2;

    }catch (Exception e){
      //it does not go here!!!
      System.out.println(e.getMessage());
    }
    System.out.println(result.isInfinite());  //true
  }

  void checkIsInfinite() {
    boolean isInfinite = Double.isInfinite(4.0 / 0);
    System.out.println(isInfinite);  //true
    isInfinite = Double.isInfinite(4.0 / 1);
    System.out.println(isInfinite);  //false

  }

}
