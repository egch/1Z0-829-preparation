package org.enricogiurin.ocp17.book.ch7.nested.inner;

public class NestedEnum {

  public static void main(String[] args) {
    new NestedEnum().use();
  }

  void use() {
    Binary binary = Binary.ZERO;
    System.out.println(binary);
    TypeOfInteger type = TypeOfInteger.EVEN;
    System.out.println(type.getDescription());
  }

  //inner class, such as enum, can be declared private, protected, public, static, final
  public enum Binary {
    ZERO, ONE
  }

  private enum TypeOfInteger {
    ODD("odd numbers"), EVEN("even numbers");

    private String description;

    TypeOfInteger(String description) {
      this.description = description;
    }

    String getDescription() {
      return description;
    }

  }

}
