package org.enricogiurin.ocp17.book.ch6.extendprotected.ex2.animals;

public class Pet {
  protected void eat() {
    System.out.println("Pet eating");
  }


  public static void main(String[] args) {
    Pet pet = new Pet();
    //here I can access to the protected method ONLY because I am in the same package!
    //protected access on Pet
    pet.eat();
  }

}
