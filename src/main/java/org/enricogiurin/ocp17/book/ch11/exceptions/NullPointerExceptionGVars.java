package org.enricogiurin.ocp17.book.ch11.exceptions;

public class NullPointerExceptionGVars {

  public static void main(String[] args) {
    NullPointerExceptionGVars instance = new NullPointerExceptionGVars();
    //instance.leftAssignment();
    instance.exceptionRightSide();
  }

  //Exception in thread "main" java.lang.NullPointerException: Cannot invoke "String.length()" because "age" is null
  //age is printed in the stacktrace
  void leftAssignment() {
    String age = null;
    if(age.length()>2){
      System.out.println("not a child");
    }
  }

  //Exception in thread "main" java.lang.NullPointerException: Cannot invoke "java.lang.Integer.intValue()" because "null" is null
  //here age is not printed
  void exceptionRightSide() {
    int age = (Integer)null;
  }

}
