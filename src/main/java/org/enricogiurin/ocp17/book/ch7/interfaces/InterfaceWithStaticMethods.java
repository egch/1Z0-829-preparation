package org.enricogiurin.ocp17.book.ch7.interfaces;

interface Certifications {

  //public by default
  public static void ocp17() {
    System.out.println("coming soon");
  }

  private static void az204() {
  }

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

public class InterfaceWithStaticMethods {

  public static void main(String[] args) {
    //I can access to static methods from everywhere
    Certifications.ocp17();
    MyCertifications myCertifications = new MyCertifications();
    //Static method may be invoked on containing interface class only
    //I cannot invoke a static method of the interface from an instance of the class which implements the interface!
    //myCertifications.ocp17();  //DOES NOT COMPILE!
  }

}

