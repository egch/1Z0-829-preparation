package org.enricogiurin.ocp17.ch4;

public class UseOfMath {

  public static void main(String[] args) {
    new UseOfMath().random();
  }
  void minAndMax() {
    int a = 4, b = 5;
    //5
    System.out.println(Math.max(a, b));
    //4
    System.out.println(Math.min(a, b));
  }

  void round() {
    long round = Math.round(5.2D);
    //5
    System.out.println(round);
    round = Math.round(5.5D);
    //6
    System.out.println(round);

    round = Math.round(5.1F);
    System.out.println(round);
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
