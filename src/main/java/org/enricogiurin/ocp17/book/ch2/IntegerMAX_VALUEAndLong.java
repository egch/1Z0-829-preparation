package org.enricogiurin.ocp17.book.ch2;

public class IntegerMAX_VALUEAndLong {

  public static void main(String[] args) {
    new IntegerMAX_VALUEAndLong().sum();
  }

  void sum() {
    int n1 = Integer.MAX_VALUE;
    int n2 = Integer.MAX_VALUE;
    int sumAsInt = n1 + n2;
    long sumAsLongWrong = n1 + n2;
    //this is the proper way to sum two int whose sum can exceed the int capacity!
    long sumAsLongRight = (long) n1 + n2;

    //sumAsInt -2 - sumAsLongWrong: -2 - sumAsLongRight: 4294967294
    System.out.println(
        "sumAsInt %d - sumAsLongWrong: %d - sumAsLongRight: %d".formatted(sumAsInt, sumAsLongWrong,
            sumAsLongRight));
  }

}
