package org.enricogiurin.ocp17.ch11.exceptions;

public class UseOfFinally {

  public static void main(String[] args) {
    UseOfFinally instance = new UseOfFinally();

    //int calculate = instance.calculate();
    //System.out.println(calculate);

    instance.systemExit();
  }

  void invokeCalculate() {
    int result = calculate();
    System.out.println(result); //3
  }

  //it always returns 3
  private int calculate() {
    try {
      System.out.println("try");
      int go =  2 / 0;
      return 1;
    } catch (Exception e) {
      System.out.println("catch");
      return 2;
    } finally {
      System.out.println("finally");
      //this has priority over the other return
      return 3;
    }
  }

  void systemExit() {
    try {
      System.out.println("try");
      //it exits here
      System.exit(1);
      System.out.println("exit");  //this won't be executed but no compile error
    } catch (Exception e) {
      System.out.println("catch");
    } finally {
      //in this case finally won't be executed
      System.out.println("finally");
    }

  }
}
