package org.enricogiurin.ocp17.book.ch7.nested;

public class LocalClass {

  private int length;

  public LocalClass(int length) {
    this.length = length;
  }

  public static void main(String[] args) {
    LocalClass localClass = new LocalClass(10);
    localClass.calculate(Integer.parseInt(args[0]));
  }

  public void calculate(int x) {
    int width = 10;
    //I cannot re-assign it
    //Variable 'width' is accessed from within inner class, needs to be final or effectively final
    //width = 12;
    //nested local class
    class Calculator {

      public void multiply() {
        System.out.println(width * length);
        System.out.println(x);
      }
    }
    var calculator = new Calculator();
    calculator.multiply();

  }
}
