package org.enricogiurin.ocp17.crashcourse.initialization;

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
//  Child() { super(x); }
  Child() { super(100); } // avoid the compilation failure!
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
//What is the result?
//A) Compilation fails
//B) Exception at runtime
//C) Hello!, P-si: x is 0, C-si: y is 300, P-i: y is 101, P-c: y is 401, C-i x: is 200 Goodbye!
//D) , P-si: x is 0, C-si: y is 300Hello!, P-i: y is 101, P-c: y is 401, C-i x: is 200 Goodbye!
//E) Hello!, P-si: x is 99, C-si: y is 300, P-i: y is 101, P-c: y is 100Goodbye!

public class Example {
}
