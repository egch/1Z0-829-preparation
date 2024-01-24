package org.enricogiurin.ocp17.book.ch1.primitive;

public class Hexadecimal {

  public static void main(String[] args) {
    new Hexadecimal().example2();
  }

  void example() {
    int x = 0x0ABCDEF;
    int converted = converter(x);
    System.out.println("original %d - converted: %d".formatted(x, converted));
  }

  void example2() {
    //X uppercase
    int hex1 = 0XAB;
    //x uppercase, literals lowercase
    int hex3 = 0Xab;
    //x lowercase
    int hex2 = 0xAB;
    //x lowercase, literals lowercase
    int hex4 = 0xab;
    //171-171-171-171
    //11(B)+10*16 = 171
    System.out.println(
        "hex1 %d - hex2: %d - hex3: %d - hex4: %d".formatted(hex1, hex2, hex3, hex4));
  }

  private int converter(int hexValue) {
    int result = 0, reminder = 0, base = 1;
    while (hexValue > 1) {
      reminder = hexValue % 16;
      System.out.print(reminder + " ");
      result += reminder * base;
      hexValue /= 16;
      base *= 16;
    }
    System.out.println();
    return result;
  }

}
