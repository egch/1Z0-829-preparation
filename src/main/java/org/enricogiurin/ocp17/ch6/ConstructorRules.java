package org.enricogiurin.ocp17.ch6;

public class ConstructorRules {
}

class Triangle {
  private final double base;
  private final double height;

  public Triangle(double base) {
    //wrong the first command should be this()
    //System.out.println("This is a isosceles triangle.");
    this(base, base);
    System.out.println("This is a isosceles triangle."); //here it's fine
  }

  public Triangle(double base, double height) {
    //does not compile: Recursive constructor invocation
    //this(base, height);

    this.base = base;
    this.height = height;
  }

  public Triangle() {
    this(1);
  }
}
