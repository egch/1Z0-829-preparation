package org.enricogiurin.ocp17.book.ch1.primitive;

public class Octal {

  public static void main(String[] args) {
    new Octal().convertOctal();
  }

  void example() {
    int x = 012;  //2 + 1*8 = 10
    int y = 023;  //3 + 2*8 = 19
    int sum = x + y;
    System.out.println(sum);  //29
  }

  void convertOctal() {
    int octal = 076361;
    int converted = converter(octal);
    System.out.println("original: %d - converted: %d".formatted(octal, converted));
  }

  private int converter(int octal) {
    final int base = 8;
    int result = 0, reminder = 0, partial = 1;
    while (octal > 1) {
      reminder = octal % base;
      result += reminder * partial;
      partial *= base;
      octal /= base;
    }
    return result;
  }

}
