package org.enricogiurin.ocp17.ch2;

public class Casting {

  public static void main(String[] args) {
    new Casting().castingLong();
  }

  void castingLong() {
    //too big for int (32 bit signed).
    //max  value for int is 2^31-1

    // int tooBig = 12345678912;

    //still it does not compile
    //long tooBig = (long)12345678912;
    //this works as the right side is declared as a long
    long tooBig = 12345678912L;
  }

  void castingShort() {
    short x = 5;
    short y = 6;
    //does not compile as short are promoted to int if there is an operator
    //short result = x + y;
    //this works
    int result = x + y;
    //this is ok as I cast to short
    short shortResult = (short)(x+y);
    //this is not ok as the RHS produces an int
   // short wrong = (short)x + y;
  }

  void literal() {
    //this is ok as 4, 6 are literal
    short x = 4+6;

    short hat = 4;
    //this does not compile as only 5 is a literal
   // short result = 5+hat;
  }

}
