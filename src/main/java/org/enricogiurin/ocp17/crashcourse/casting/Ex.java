package org.enricogiurin.ocp17.crashcourse.casting;

public class Ex {
    public static void main(String[] args) {
//    Base b = new Sub();
        Base b = new Base();
        // compiler allows methods know to be valid based on
        // COMPILE-TIME type of the reference...
        // but BEHAVIOR is based on RUNTIME type of the object
        b.doBaseStuff();
//    ((Sub)b).doOtherStuff();
        // impossible casts are rejected by the compiler
//    ((String)b).length();

        ((Runnable) b).run();
    }
}

/*final*/ class Base {
    void doBaseStuff() {
        System.out.println("doBaseStuff");
    }
}

//class Sub extends Base implements Runnable {
//  void doBaseStuff() { System.out.println("doSubStuff"); }
//  void doOtherStuff() { System.out.println("doOtherStuff"); }
//
//  @Override
//  public void run() {
//
//  }
//}
