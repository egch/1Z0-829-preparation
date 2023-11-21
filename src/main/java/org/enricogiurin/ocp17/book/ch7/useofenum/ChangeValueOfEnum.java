package org.enricogiurin.ocp17.book.ch7.useofenum;

enum Animal {
  CAT("A small domesticated feline."),
  DOG("A domesticated caned with various breeds."),
  BIRD("A warm-blooded, feathered vertebrate.");

  private String description;

  Animal(String description) {
    this.description = description;
  }

  public String getDescription() {
    return description;
  }

  //While it is not recommended to change the value of an enum after it is created, it is legal.
  public void setDescription(String description) {
    this.description = description;
  }
}

public class ChangeValueOfEnum {

  public static void main(String[] args) {
    new ChangeValueOfEnum().changeValueToEnum();
  }

  void changeValueToEnum() {
    Animal cat = Animal.CAT;
    System.out.println(cat.getDescription()); //A small domesticated feline.
    cat.setDescription("I love cats!");
    System.out.println(cat.getDescription()); //I love cats!
  }


}