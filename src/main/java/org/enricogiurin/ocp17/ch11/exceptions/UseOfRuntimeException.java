package org.enricogiurin.ocp17.ch11.exceptions;

public class UseOfRuntimeException {

  public static void main(String[] args) {
    new UseOfRuntimeException().numberFormatException();
  }

  void arithmeticException() {
    //Exception in thread "main" java.lang.ArithmeticException: / by zero
    int result = 5 / 0;
  }

  void classCastException() {
    String message = "ciao";
    Object ref = message;

    //Exception in thread "main" java.lang.ClassCastException: class java.lang.String
    // cannot be cast to class java.lang.Integer (java.lang.String and java.lang.Integer are in module java.base of loader 'bootstrap')
    Integer number = (Integer) ref;
  }

  void arrayIndexOutOfBoundsException() {
    int[] array = {};
    //Exception in thread "main" java.lang.ArrayIndexOutOfBoundsException: Index 0 out of bounds for length 0
    int first = array[0];
  }

  void nullPointerException() {
    String message = "ciao";
    message = null;
    //Exception in thread "main" java.lang.NullPointerException: Cannot invoke "String.length()" because "message" is null
    int length = message.length();
  }

  void numberFormatException() {
    //Exception in thread "main" java.lang.NumberFormatException: For input string: "abc"
    int value = Integer.parseInt("abc");
  }


}
