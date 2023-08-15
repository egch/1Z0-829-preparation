package org.enricogiurin.ocp17.ch1;

public class Chick {

  private String name = "Fluffy";

  {
    System.out.println("setting field");
  }

  public Chick() {
    name = "Tiny";
    System.out.println("setting constructor");
  }

  public static void main(String[] args) {
    Chick chick = new Chick();
    System.out.println(chick.name);
  }

    /*
     1. setting fields
     2. setting constructor
     3. Tiny
     */
}
