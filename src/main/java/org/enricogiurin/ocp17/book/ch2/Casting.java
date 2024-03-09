package org.enricogiurin.ocp17.book.ch2;

public class Casting {

  public static void main(String[] args) {
    new Casting().dangerousCast();
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
    short shortResult = (short) (x + y);
    //this is not ok as the RHS produces an int
    // short wrong = (short)x + y;
  }

  void literal() {
    //this is ok as 4, 6 are literal
    short x = 4 + 6;

    short hat = 4;
    //this does not compile as only 5 is a literal
    // short result = 5+hat;
  }

  void castingBoolean() {
    Object s = false;
    boolean b = (boolean) s;
    Boolean aBoolean = false;
    boolean c = (boolean) aBoolean;
  }

  void shortAndInt() {
    int n = 5;
    short s = 5;
    useInt(n);
    //cannot cast int to short
    //useShort(n);  //does not compile

    //casting a short into int
    useInt(s);
    useShort(s);
  }

  void castingPrimitiveToObject() {
    byte b = 4;
    short s = 5;
    int i = 56;
    long l = 100L;
    float f = 4.5F;
    double d = 5.98D;
    char c = 'a';
    boolean bo = false;

    //all of these can be cast to Object
    Object oB = (Object) b;
    Object oS = (Object) s;
    Object oI = (Object) i;
    Object oL = (Object) l;
    Object oF = (Object) f;
    Object oD = (Object) d;
    Object oC = (Object) c;
    Object oBo = (Object) bo;
    //inconvertible types; cannot cast 'int' to 'java.lang.Float'
    //Float aFloat = (Float)i;  DOES NOT COMPILE
  }

  void dangerousCast() {
    int[][] array = {{1, 2, 3}, {2}};
    //keep in mind that int[] is an object;
    Object[] arrObj = array;
    //compiles but exception at runtime
    //Exception in thread "main" java.lang.ArrayStoreException: java.lang.String
    arrObj[0] = "hello";
  }


  private void useShort(short s) {

  }

  private void useInt(int s) {
  }

}
