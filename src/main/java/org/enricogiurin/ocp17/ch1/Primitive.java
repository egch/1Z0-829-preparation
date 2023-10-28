package org.enricogiurin.ocp17.ch1;

public class Primitive {

  public static void main(String[] args) {
    new Primitive().printDouble();
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
}
