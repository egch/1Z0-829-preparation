package org.enricogiurin.ocp17.ch3;

public class Loop {

  public static void main(String[] args) {
    new Loop().forPreIncrementVsPostIncrement();
  }

  void loopWithDouble() {
    for (double x = 0; x < 10; x++) {
      System.out.println(x);
    }
  }

  void forPreIncrementVsPostIncrement() {
    int[] array = new int[]{5, 10, 15, 20};

    //post increment and pre increment are the same in a for loop
    for (int i = 0; i < array.length; i++) {
      System.out.print(array[i] + " ");
    }
    System.out.println();
    for (int i = 0; i < array.length; ++i) {
      System.out.print(array[i] + " ");
    }
  }
}
