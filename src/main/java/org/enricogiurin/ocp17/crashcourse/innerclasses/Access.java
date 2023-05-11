package org.enricogiurin.ocp17.crashcourse.innerclasses;

class Outer1 {
  class Inner1 {
//    int x = 100;
    private int y = 100;
    // line n1
    Inner1 makeOne() { // this would work, Outer1.this is implicit
//    static Inner1 makeOne() { // fails, no enclosing instance
//      return new Inner1(); // fails with static context
//      return new Outer1().new Inner1(); // OK with static or instance context
      return /*Outer1.this.*/new Inner1(); // OK with static or instance context
    }
    void showX() {
      System.out.println("x is " + /*Outer1.this.*/x);
    }
  }
  class Inner2 {
    void showAnotherY(Inner1 another) {
      System.out.println("y is " + another.y);
    }
  }
  private int x = 99;
  // line n2
//  static Inner1 makeOne() { return new Inner1(); }
//  void showY() {
//    System.out.println("y is " + y); // NOPE, which Inner??
//  }
  void showAnotherY(Inner1 another) {
    System.out.println("y is " + another.y);
  }
}

//    void showX() { sop("x is " + x); }
//    void showY() { sop("y is " + y); }
//    void showAnotherY(Inner1 another) { sop("y is " + another.y); }
//static Inner1 makeOne() { return new Inner1(); }
public class Access {
}
