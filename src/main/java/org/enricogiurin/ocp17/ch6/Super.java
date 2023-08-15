package org.enricogiurin.ocp17.ch6;

public class Super {

  public static void main(String[] args) {
    Reptile croc = new Crocodile();
    System.out.println(croc.speed);  //10 ! be careful!!!

    Crocodile croc2 = new Crocodile();
    System.out.println(croc2.speed);  //20

    var croc3 = new Crocodile();
    System.out.println(croc3.speed);  //20
    System.out.println(croc3.getSuperSpeed());  //10

  }


}

class Reptile {

  protected int speed = 10;
}

class Crocodile extends Reptile {

  protected int speed = 20;

  public int getSpeed() {
    return speed;
  }

  public int getSuperSpeed() {
    return super.speed;
  }
}
