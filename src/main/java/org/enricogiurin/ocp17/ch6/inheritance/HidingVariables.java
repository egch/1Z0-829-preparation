package org.enricogiurin.ocp17.ch6.inheritance;

public class HidingVariables {

  public static void main(String[] args) {
    English english = new English();
    Language en = english;
    System.out.println(english.a);  //20
    System.out.println(en.a); //10
  }
}

class Language {

  protected int a = 10;

}

class English extends Language {

  public int a = 20;

}
