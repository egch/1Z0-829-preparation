package org.enricogiurin.ocp17.ch7.interfaces;

public interface InterfaceWithPrivateMethods {

  //interface variables are implicitly : public, static, final
  int x = 5;

  void hello(String name);


  //a default method can call a private method
  default void sayCiao() {
    String message = ciao();
    System.out.println(message);
  }

  private String ciao() {
    return "ciao";
  }
}

class Concrete implements InterfaceWithPrivateMethods {

  public static void main(String[] args) {
    InterfaceWithPrivateMethods instance = new Concrete();
    instance.sayCiao();  //ciao

  }

  @Override
  public void hello(String name) {

  }
}
