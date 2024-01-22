package org.enricogiurin.ocp17.book.ch4;

public class UseOfMath {

  public static void main(String[] args) {
    new UseOfMath().round();
  }

  void minAndMax() {
    int a = 4, b = 5;
    //5
    System.out.println(Math.max(a, b));
    //4
    System.out.println(Math.min(a, b));
  }

  void round() {
    //Note that it returns a Long for a double
    long roundADouble = Math.round(5.2D);
    System.out.println(roundADouble);     //5
    roundADouble = Math.round(5.5D);
    System.out.println(roundADouble);  //6

    //now using float
    int roundAFloat = Math.round(5.5F);
    System.out.println(roundAFloat);  //6
  }

  void ceilAndFloor() {
    double ceil = Math.ceil(4D);
    System.out.println(ceil); //4.0
    ceil = Math.ceil(4.1D);
    System.out.println(ceil);  //5.0
    double floor = Math.floor(4D);
    System.out.println(floor);  //4.0
    floor = Math.floor(4.1D);
    System.out.println(floor);  //4.0
  }

  void pow() {
    double pow = Math.pow(2, 3);
    //8.0
    System.out.println(pow);

    double eulero = Math.exp(3);
    //20.085536923187668
    System.out.println(eulero);
  }

  void random() {
    double random = Math.random();
    //random number >=0 & < 1
    System.out.println(random);

  }

}
