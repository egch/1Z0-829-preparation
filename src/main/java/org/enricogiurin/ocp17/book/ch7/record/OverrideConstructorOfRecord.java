package org.enricogiurin.ocp17.book.ch7.record;

public class OverrideConstructorOfRecord {

  public record Dog(String name) {

    //I can override the "default" constructor of a record
    //custom constructor
    public Dog(String name) {
      this.name = name;
    }

    //overloaded constructor
    public Dog() {
      this("Jimmy");
      //I can access to this.name but I cannot re-assign the value as it is final
      System.out.println(this.name);
    }
  }

}
