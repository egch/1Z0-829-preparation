package org.enricogiurin.ocp17.ch5;

public class StringToLong {

  public static void main(String[] args) {
    StringToLong instance = new StringToLong();
    instance.parseLong();
    instance.valueOf();
  }

  void parseLong() {
    //this method returns a primitive long
    var aLongPrimitive = Long.parseLong("123");
    //doest not compile
    // System.out.println(aLongPrimitive.toString());

    System.out.println(aLongPrimitive);
  }

  void valueOf() {
    //this method returns a Long object
    var aLong = Long.valueOf("123");
    System.out.println(aLong.toString());
  }

}
