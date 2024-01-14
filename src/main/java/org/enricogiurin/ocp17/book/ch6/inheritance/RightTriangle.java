package org.enricogiurin.ocp17.book.ch6.inheritance;

abstract class Triangle {
  abstract String getDescription();
}
abstract class IsoRightTriangle extends RightTriangle { // g1
  public String getDescription() { return "irt"; }
}
public class RightTriangle extends Triangle {
  //this method is fine because protected has broader access than package
  //in the class Triangle
  protected String getDescription() { return "rt"; }
  public static void main(String[] edges) {
    //I cannot instantiate an abstract class
/*    final var shape = new IsoRightTriangle();
    System.out.print(shape.getDescription());*/
  } }
