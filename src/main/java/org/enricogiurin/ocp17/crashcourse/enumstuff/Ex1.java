package org.enricogiurin.ocp17.crashcourse.enumstuff;

enum Day {
  MONDAY(1), TUESDAY{};
  // enum constructors default to private and must be private
  /*public*/ Day(int d) {}
  /*public*/ Day() {}


  @Override
  public String toString() {
    return "I'm an enum value is " + name();
  }
//  public String name() {} //NOPE, name is final :)
}

public class Ex1 {
  public static void main(String[] args) {
    System.out.println(Day.MONDAY);
    System.out.println(Day.MONDAY.getClass());
    System.out.println(Day.TUESDAY.getClass());

    Day m = Day.valueOf("MONDAY");

    for (var d : Day.values()) {
      System.out.println("> " + d);
      System.out.println("ordinal is " + d.ordinal());
    }
  }
}
