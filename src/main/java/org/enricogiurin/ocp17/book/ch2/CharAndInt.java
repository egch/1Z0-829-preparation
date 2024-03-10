package org.enricogiurin.ocp17.book.ch2;

//TODO - to complete
public class CharAndInt {

  public static void main(String[] args) {
    new CharAndInt().charToUnicode();
  }

  void conversion() {
    char c = 'a';
    int cAsAnInt = c;
    System.out.println(cAsAnInt);  //97
  }

  void unicode() {
    //note: \u0061 means in hex, 6*16+1 = 97 (in decimal)
    char c = '\u0061';
    char d = 'a';
    System.out.println(c == d); //true
    System.out.println('\u0061');
    int charAsInt = c;
    System.out.println("char as int: "+charAsInt);  //97
  }

  void byteToChar() {
    char c = 'a';
    byte b = 'a';
    int cAsAnInt = c;
    //byte s = c;  //does not compile
    byte b2 = (byte) c; // Requires explicit cast due to potential loss of information

    char myChar = '€';
    // € is  8364, out of scale for byte
    //byte euro = '€';

    char euro = '\u20ac';
    System.out.println(euro);
  }

  void byte2() {
    //out of range
    //byte b = 256;  //does not compile.

    byte b = 'a';
    System.out.println(b);  //97
  }

  void shortToChar() {
    char c = 'a';
    short s = 'a';
    int cAsAnInt = c;
    // short s = c;  //does not compile
    short s2 = (short) c; // Requires explicit cast due to potential loss of information
  }

  void charToUnicode() {
    char c = 'a';
    String unicode = String.format("\\u%04x", (int)c);
    System.out.println(unicode); // \u0061
  }

}
