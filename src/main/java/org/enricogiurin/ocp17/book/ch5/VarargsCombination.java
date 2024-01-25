package org.enricogiurin.ocp17.book.ch5;

public class VarargsCombination {

  public static void main(String[] args) {
    new VarargsCombination().call();

  }

  void call() {
    checkSize(1, null);  //array is null
    checkSize(1, new int[]{});  //0
    checkSize(1, 2);  //1
    checkSize(1, 1, 2); //2
    checkSize(1, new int[]{1,4});  //2
  }

  /**
   * varargs can only be defined as the last argument in the list and it can
   * be only present once at most.
   * @param a
   * @param array
   */
  void checkSize(int a, int... array){
    if(array==null){
      System.out.println("array is null");
      return;

    }
    final int size = array.length;
    System.out.println("size is: %d".formatted(size));

  }

}
