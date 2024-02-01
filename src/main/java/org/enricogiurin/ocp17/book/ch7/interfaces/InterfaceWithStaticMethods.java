package org.enricogiurin.ocp17.book.ch7.interfaces;

public class InterfaceWithStaticMethods {

  public static void main(String[] args) {
    //I can access to static methods from everywhere, no need to implement the interface
    Certifications.ocp17();
  }

}

interface Certifications {

  //public by default
  public static void ocp17() {
    System.out.println("coming soon");
  }

  private static void az204() {}

  //cannot have a final static method on an interface
  //static final void notAllowed() {}

  default void certsPassed() {
    ocp17();
    //here I call a private static method
    az204();
  }

}

class MyCertifications implements Certifications {

  void pomodoro() {
    //does not work in spite MyCertifications implements Certifications
    //ocp17();  //does not compile

    //in this way it compiles
    Certifications.ocp17();

    //az204 has private access, can only be accessed within the interface
    //Certifications.az204();  //does not compile!
  }
}