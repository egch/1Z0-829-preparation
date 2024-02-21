package org.enricogiurin.ocp17.book.ch7.interfaces;

public interface InterfaceWithPrivateMethods {

  //interface variables are implicitly : public, static, final
  int x = 5;
  //variables in interfaces need to be initialized
  //int y;  //does not compile


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

  // a private interface method cannot be called in a method outside the interface declaration.
  @Override
  public void sayCiao() {

    InterfaceWithPrivateMethods.super.sayCiao();

    //ciao()' has private access in InterfaceWithPrivateMethods'
    //ciao(); //does not compile
  }
}
