package org.enricogiurin.ocp17.ch4.string;

public class IsEmptyVsIsBlank {

  public static void main(String[] args) {
    new IsEmptyVsIsBlank().check();
  }

  void check() {
    String blankString = "  ";
    //false
    System.out.println(blankString.isEmpty());
    //true
    System.out.println(blankString.isBlank());

    String emptyString = "";
    //true
    System.out.println(emptyString.isEmpty());
    //true
    System.out.println(emptyString.isBlank());

    String normalString = "ciao";
    //false
    System.out.println(normalString.isEmpty());
    //false
    System.out.println(normalString.isBlank());
  }

}
