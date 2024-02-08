package org.enricogiurin.ocp17.book.ch7.record;

public class OverrideConstructorOfRecord {

  public record Dog(String name) {

    //I can override the "default" constructor of a record
    //custom constructor
    public Dog(String name) {
      this.name = name;
    }

    public Dog() {
      this("Jimmy");
    }
  }

}
