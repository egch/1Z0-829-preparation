package org.enricogiurin.ocp17.crashcourse.init2;

import static java.lang.System.out;

class Parent {
  Parent(int x) { y += x; out.print(", P-c: y is " + y); }
  static { out.print(", P-si: x is " + Parent.x); }
  static int x = 99;
  int y = 100;
  { y++; out.print(", P-i: y is " + y); }
}
class Child extends Parent {
  int x = 200;
  static int y = 300;
  Child() { super(y); }
  Child(int x) { this(); }
  { out.print(", C-i x: is " + x); }
  static { out.print(", C-si: y is " + y); }
}
class InitOrder3 {
  public static void main(String[] args) {
    out.print("Hello!");
    new Child(-1);
    out.println(" Goodbye!");
  }
}
public class Q {
}
