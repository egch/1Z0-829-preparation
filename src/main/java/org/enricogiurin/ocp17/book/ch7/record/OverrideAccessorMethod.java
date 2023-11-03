package org.enricogiurin.ocp17.book.ch7.record;

public class OverrideAccessorMethod {

  public static void main(String[] args) {
    BeardedDragon beardedDragon = new BeardedDragon(true, "enrico");
    //accessor method are without get, just field name
    //accessor method can be overridden
    System.out.println(beardedDragon.fun());
    System.out.println(beardedDragon.name());
  }
}

record BeardedDragon(boolean fun, String name) {

  //we just override one of the 2 accessor methods
  @Override
  public boolean fun() {
    return false;
  }
}

