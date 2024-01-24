package org.enricogiurin.ocp17.book.ch1.primitive;

public class Binary {

  public static void main(String[] args) {
    new Binary().binaryWithUnderscore();
  }

  void binary() {
    int x = 0b10;  //5
    //I can use either 0b or 0B
    int y = 0B101; //5
    int sum = x + y;
    System.out.println(sum); //7
    System.out.println("binary: %s".formatted(Integer.toBinaryString(sum))); //111
  }

  void binaryWithUnderscore() {
    int x = 0B1100_000_01;
    System.out.println(x); //385
    System.out.println("binary: %s".formatted(Integer.toBinaryString(x))); //111
  }

  void wrongBinary() {
    //if the literal starts with 0B I can only use 0 or 1
    //int wrong = 0B0000_2;  //does not compile
  }

}
