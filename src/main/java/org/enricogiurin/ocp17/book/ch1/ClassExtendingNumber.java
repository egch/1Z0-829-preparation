package org.enricogiurin.ocp17.book.ch1;

public class ClassExtendingNumber {

  public static void main(String[] args) {
    new ClassExtendingNumber().integer();
  }

  void integer() {
    //deprecated
    //Integer value = new Integer(5);
    Integer v5 = Integer.valueOf(Integer.MAX_VALUE);
    float f = v5.floatValue();
    double d = v5.doubleValue();
    //double d = v5;
    int i = v5.intValue();
    long l = v5.longValue();
    byte b = v5.byteValue();
    short s = v5.shortValue();
    String st = v5.toString();
    //-1 -1 2147483647 2147483647 2.14748365E9 2.147483647E9 -1 2147483647
    System.out.println("byte: %s".formatted(b));
    System.out.println("short: %s".formatted(s));
    System.out.println("int: %s".formatted(i));
    System.out.println("long: %s".formatted(l));
    System.out.println("float: %s".formatted(f));
    System.out.println("double: %s".formatted(d));
    System.out.println("string: %s".formatted(st));
    //byte: -1
    //short: -1
    //int: 2147483647
    //long: 2147483647
    //float: 2.14748365E9
    //double: 2.147483647E9
    //string: 2147483647

  }


}
