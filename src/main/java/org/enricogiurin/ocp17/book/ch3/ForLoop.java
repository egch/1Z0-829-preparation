package org.enricogiurin.ocp17.book.ch3;

public class ForLoop {

  public static void main(String[] args) {
    new ForLoop().forPreIncrementVsPostIncrement();
  }

  void loopWithDouble() {
    for (double x = 0; x < 10; x++) {
      System.out.println(x);
    }
  }

  void forWithContinue() {
    for (int j = 0; j < 10; j++) {
      continue;
      //Unreachable statement
/*    if(j>3){
        System.out.println(j);
      }*/
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

  void forMultipleVariables() {
    for (long x = 0, y = 0; x < 10 && y < 10; x++, y++) {
      System.out.println("x: " + x + " - y: " + y);
    }

    //You can declare multiple elements in a for loop, but the data type must be listed only once
/*  for(long x=0, long y=0; x<10 && y<10; x++, y++){
      System.out.println("x: "+x+" - y: "+y);
    }*/
  }

  void multipleVariablesInt() {
    //separation is with comma
    for (int i = 0, j = 0; i < 10 && j < 10; i++, j++) {

    }
  }


  void infiniteLoop() {
    for (; ; ) {
      System.out.println("stop me pls!");
    }
  }


  void forLabels() {
    outer:
    for (int j = 0; j < 10; j++) {
      inner:
      for (int k = 0; k < 100; k++) {
        //System.out.println("j: "+j+" - k: "+k);
        if (k + j == 7) {
          System.out.println("break inner");
          break inner;
        }
        if (k + j == 10) {
          System.out.println("continue outer");
          continue outer;
        }
      }
    }
  }
}
