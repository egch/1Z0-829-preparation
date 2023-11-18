package org.enricogiurin.ocp17.book.ch8.functionalinterface.primitive;

import java.util.function.IntUnaryOperator;

public class UseOfIntUnaryOperator {

  public static void main(String[] args) {
    new UseOfIntUnaryOperator().intUnaryOperator();
  }

  void use() {
    //note that this FI does not have generics
    IntUnaryOperator intUnaryOperator = n->n*2;
    int result = intUnaryOperator.applyAsInt(10);
    System.out.println(result);
  }

  void intUnaryOperator() {
    acceptIntUnaryOperator(n->2*n);
    acceptIntUnaryOperator(n->10+n);
    acceptIntUnaryOperator(n->10+n);
    //using anonymous inner class
    acceptIntUnaryOperator(new IntUnaryOperator() {
      @Override
      public int applyAsInt(int operand) {
        return 5*operand;
      }
    });
  }

  private void acceptIntUnaryOperator(IntUnaryOperator fi){
    int result = fi.applyAsInt(10);
    System.out.println(result);
  }



}
