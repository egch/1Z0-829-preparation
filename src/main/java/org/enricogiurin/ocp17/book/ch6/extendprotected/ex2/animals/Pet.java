package org.enricogiurin.ocp17.book.ch6.extendprotected.ex2.animals;

public class Pet {
  protected void eat() {
    System.out.println("eating");
  }

  public static void main(String[] args) {
    Pet pet = new Pet();
    //here I can ONLY because I am in the same package!
    pet.eat();
  }

}
