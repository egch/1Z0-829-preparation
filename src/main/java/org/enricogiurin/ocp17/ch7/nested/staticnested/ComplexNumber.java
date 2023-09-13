package org.enricogiurin.ocp17.ch7.nested.staticnested;

//this example was created by chatgpt
public class ComplexNumber {

  private double real;
  private double imaginary;

  public ComplexNumber(double real, double imaginary) {
    this.real = real;
    this.imaginary = imaginary;
  }

  public static void main(String[] args) {
    //ComplexNumber{real=10.3, imaginary=10.1}
    new ComplexNumber(6.3D, 5.1D)
        .add(new ComplexNumber(4D, 5D));
  }

  void add(ComplexNumber c2) {
    ComplexNumber sum = new Utils().add(this, c2);
    System.out.println(sum);
  }

  @Override
  public String toString() {
    return "ComplexNumber{" +
        "real=" + real +
        ", imaginary=" + imaginary +
        '}';
  }

  // Other methods for complex number operations

  // Static nested class for utility functions
  public static class Utils {

    public ComplexNumber add(ComplexNumber num1, ComplexNumber num2) {
      //it cannot access to fields of the outer class
      // double real1 = ComplexNumber.this.real;  //does not compile
      double realSum = num1.real + num2.real;
      double imagSum = num1.imaginary + num2.imaginary;
      return new ComplexNumber(realSum, imagSum);
    }

    public ComplexNumber multiply(ComplexNumber num1, ComplexNumber num2) {
      double realProduct = num1.real * num2.real - num1.imaginary * num2.imaginary;
      double imagProduct = num1.real * num2.imaginary + num1.imaginary * num2.real;
      return new ComplexNumber(realProduct, imagProduct);
    }
  }
}
