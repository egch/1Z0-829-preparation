package org.enricogiurin.ocp17.ch11;

public class ShowNPEVariable {

  public static void main(String[] args) {
    new ShowNPEVariable().show();
  }

  void show() {
    //Exception in thread "main" java.lang.NullPointerException: Cannot invoke "java.lang.Integer.intValue()" because "dewey" is null
    var huey = (String) null;
    Integer dewey = null;
    Object louie = null;
    if (louie == huey.substring(dewey.intValue())) {
      System.out.println("Quack!");
    }
  }
}
