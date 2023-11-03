package org.enricogiurin.ocp17.book.ch6.animal;


public class Reptile {

  protected int speed = 5;
  protected int weight = 10;
}

class Crocodile extends Reptile {

  //this speed has nothing to do with the speed defined in the Reptile class
  //in spite they have the same name
  int speed = 10;
  String skinColor = "green";

  public static void main(String[] args) {
    Crocodile crocodile = new Crocodile();
    crocodile.printProperties();

    Reptile reptile = new Crocodile();
    //I cannot call print properties having a reference to the parent class
    //reptile.printProperties(); //does not compile

  }

  int getSpeed() {
    //we use super to refer to the parent class
    return Math.max(this.speed, super.speed);
  }

  void printProperties() {
    //speed is defined (independently) in both the parent and the child class
    System.out.println("reptile speed: " + super.speed);
    System.out.println("crocodile speed: " + this.speed);
    //if not specified it uses the this
    System.out.println("what speed is used?: " + speed);

    //weight belongs only to the parent class but can be accessed as super or this
    System.out.println("reptile weight: " + super.weight);
    System.out.println("crocodile weight: " + this.weight);

    //skinColor is only defined in the child class, therefore, cannot be accessed with the super.
    //System.out.println("reptile skinColor: "+super.skinColor); does not compile
    System.out.println("crocodile skinColor: " + this.skinColor);
  }


}

