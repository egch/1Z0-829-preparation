package org.enricogiurin.ocp17.ch2;

public class LogicalOperators {

  public static void main(String[] args) {
    new LogicalOperators().logical();
  }
  void logical(){
    //both the condtions are evaluated, no matter if the first is false
    if(evalFalse() & evalTrue()){
      System.out.println("true");
    }else{
      System.out.println("false");
    }

    //both the conditions are evaluated, no matter if the first is true
    if(evalTrue() | evalFalse()){
      System.out.println("true");
    }else{
      System.out.println("false");
    }

  }

  private boolean evalTrue(){
    System.out.println("evalTrue");
    return true;
  }

  private boolean evalFalse(){
    System.out.println("evalFalse");
    return false;
  }

}
