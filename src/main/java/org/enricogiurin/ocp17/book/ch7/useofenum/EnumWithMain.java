package org.enricogiurin.ocp17.book.ch7.useofenum;

public enum EnumWithMain {
  A(), B();

  public static void main(String[] args) {
    //Enum types cannot be instantiated
    //new EnumWithMain();  //DOES NOT COMPILE
  }
}
