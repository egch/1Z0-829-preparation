package org.enricogiurin.ocp17.ch7.interfaces.defaultmethods;

interface MyDefault {

  default String message() {
    return "This is the default method";
  }
}

public class DefaultMethods implements MyDefault {

  public static void main(String[] args) {
    DefaultMethods defaultMethods = new DefaultMethods();
    String s = defaultMethods.message();
    System.out.println(s);
    s = defaultMethods.defaultMessage();
    System.out.println(s);

  }

  @Override
  public String message() {
    return "This is the class method's implementation";
  }

  //how to refer to the default method
  public String defaultMessage() {
    return MyDefault.super.message();
  }
}


