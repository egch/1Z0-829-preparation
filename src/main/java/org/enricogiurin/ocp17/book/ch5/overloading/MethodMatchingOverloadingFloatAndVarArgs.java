package org.enricogiurin.ocp17.book.ch5.overloading;

public class MethodMatchingOverloadingFloatAndVarArgs {

  public static void main(String[] args) {
    new MethodMatchingOverloadingFloatAndVarArgs().call();
  }

  void call(){
    method(1, 1.2);  // Object obj1, Object obj2
    method(1, 2); // int n1, int n2
    method(1.3, 2.3); // Object obj1, Object obj2
    method(1.3F, 2.3F); // float f1, float f2
    method(Float.valueOf(1.3f)); // float... vararg
    method(Float.valueOf(1.3f), Float.valueOf(5.2F)); // Float f1, Float f2
    method(1.3F); // float... vararg
    method(); // float... vararg
  }

  void method(float f1, float f2){
    System.out.println("float f1, float f2");
  }
  void method(int n1, int n2){
    System.out.println("int n1, int n2");
  }

  void method(float... vararg){
    System.out.println("float... vararg");
  }

  void method(Float f1, Float f2){
    System.out.println("Float f1, Float f2");
  }

  void method(Object obj1, Object obj2){
    System.out.println("Object obj1, Object obj2");
  }


}
