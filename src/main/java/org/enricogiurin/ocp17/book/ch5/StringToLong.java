package org.enricogiurin.ocp17.book.ch5;

public class StringToLong {

  public static void main(String[] args) {
    StringToLong instance = new StringToLong();
    instance.valueOfInvalidNumber();
    //instance.valueOf();
  }

  void parseLong() {
    //this method returns a primitive long
    var aLongPrimitive = Long.parseLong("123");
    //doest not compile
    // System.out.println(aLongPrimitive.toString());

    System.out.println(aLongPrimitive);
  }

  //Exception in thread "main" java.lang.NumberFormatException: For input string: "not a long"
  void parseInvalidNumber() {
    long result = Long.parseLong("not a long");
    System.out.println(result);

  }

  void valueOf() {
    //this method returns a Long object
    var aLong = Long.valueOf("123");
    //aLong is a Long
    System.out.println(aLong.toString());
  }

  // Exception in thread "main" java.lang.NumberFormatException: For input string: "not a Long"
  void valueOfInvalidNumber() {
    Long result = Long.valueOf("not a Long");
    System.out.println(result);

  }

}
