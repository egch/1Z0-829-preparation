package org.enricogiurin.ocp17.book.ch7.useofenum;

enum CardinalPointsWithDescription {

  NORTH("North direction") {
    //this method only belong to the NORTH
    public void sayYouAreInTheNorth() {
      System.out.println("I'm the NORTH");
    }
  },
  SOUTH("South direction"),
  EAST("East direction"),
  WEST("West direction");
  private final String description;  //here semicolon is mandatory

  //Modifier 'private' is redundant for enum constructors
  private CardinalPointsWithDescription(String description) {
    this.description = description;
  }

  //this method belong to all the enums
  void printDescription() {
    System.out.println("desscription : " + description);
  }

  //this is needed in order to have the method in the NORTH
  //this is the default method which is overridden in the NORTH
  void sayYouAreInTheNorth() {
  }
}

public class EnumWithFields {

  public static void main(String[] args) {
    new EnumWithFields().methods();


  }

  void methods() {
    CardinalPointsWithDescription enumWithFields = CardinalPointsWithDescription.NORTH;
    enumWithFields.printDescription();
    enumWithFields.sayYouAreInTheNorth();
  }

}