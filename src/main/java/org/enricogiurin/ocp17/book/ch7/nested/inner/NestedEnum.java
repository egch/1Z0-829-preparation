package org.enricogiurin.ocp17.book.ch7.nested.inner;

public class NestedEnum {

  public static void main(String[] args) {
    new NestedEnum().use();
  }
  //inner class, such as enum, can be declared private, protected, public, static, final
  public enum Binary {
    ZERO, ONE
  }

  private enum TypeOfInteger {
    ODD("odd numbers"), EVEN("even numbers");

    String getDescription() {
      return description;
    }

    private String description;
    TypeOfInteger(String description) {
      this.description = description;
    }

  }

  void use() {
    Binary binary = Binary.ZERO;
    System.out.println(binary);
    TypeOfInteger type = TypeOfInteger.EVEN;
    System.out.println(type.getDescription());
  }

}
