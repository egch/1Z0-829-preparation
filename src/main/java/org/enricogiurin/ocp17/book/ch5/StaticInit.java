package org.enricogiurin.ocp17.book.ch5;

public class StaticInit {

  static String name = "enrico";

  //this is a static block
  static {
    name = "mario";
  }

  //this is not a static block and it's executed when a new instance is created
  {
    name = "gigi";
  }

  public static void main(String[] args) {
    System.out.println(name);  //mario
    new StaticInit();  //the instantiation of this class has the side effect to change value of name
    System.out.println(name);  //gigi

  }
}
