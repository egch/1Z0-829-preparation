package org.enricogiurin.ocp17.book.ch7.nested.local;

public class LocalClassWithAttributeNameInConflict {

  public static void main(String[] args) {
    new LocalClassWithAttributeNameInConflict().sum();
  }

  public int sum() {
    final int op = 5;
    class Math {

      int localSum() {
        //how to access to the op defined in the enclosed method?
        // final int op = 5;
        int op = 10;
        return op;
      }
    }
    return new Math().localSum();
  }
}
