package org.enricogiurin.ocp17.ch6.inheritance;


public class OverrideInstanceVariables {

  public static final void main(String[] fuel) {
    new Rocket().printDetails(); //3,4
  }
}
class Ship {
  protected int weight = 3;
  protected int height = 5;
  public int getWeight() { return weight; }
  public int getHeight() { return height; }
}
class Rocket extends Ship {
  public int weight = 2;
  public int height = 4;
  //he super.getWeight() method returns 3 from the variable in the parent class,
  // as polymorphism and overriding do not apply to instance variables.
  public void printDetails() {
    System.out.print(super.getWeight() + "," + this.height);
  }
 }
