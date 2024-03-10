package org.enricogiurin.ocp17.book.ch1.primitive;

public class Primitive {

  public static void main(String[] args) {
    new Primitive().compareIntWithFloat();
  }

  void validUsage() {

    int binary = 0b11; //starts with 0b

    //invalid: incompatible types: possible lossy conversion from long to int
    //int longValue = 0L;

    int hexadecimal = 0XE; //hexadecimal

    int underscore = 1_2_0;

    double d_underscore = 9_2.1_2;

    //invalid: incompatible types: possible lossy conversion from double to float
    //float aFloat = 2.3;

    //valid as I use the suffix F
    float aFloat = 2.3F;


/*
    D. int amount = 1_2.0;
    E. double amount = 1_0_.0; F. int amount = 0b101;
    G. double amount = 9_2.1_2; H. double amount = 1_2_.0_0;*/
  }

  void printDouble() {
    double d = 5;
    System.out.println(d); //5.0
  }

  void compareIntWithFloat() {
    int x = 5;
    float f = 5.0F;
    //x will be promoted to float in the comparison
    if (x == f) {
      System.out.println("equals");  //equals
    } else {
      System.out.println("not equals");
    }
  }
}
