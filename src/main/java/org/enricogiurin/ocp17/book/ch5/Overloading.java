package org.enricogiurin.ocp17.book.ch5;

public class Overloading {

  public static void main(String[] args) {
    Overloading t = new Overloading();
    short s = 123;
    t.print(s);
    t.print(true);
    t.print(6.789);

    //int - Object - Object
  }

  public void print(byte x) {
    System.out.print("byte-");
  }

  public void print(int x) {
    System.out.print("int-");
  }

  public void print(float x) {
    System.out.print("float-");
  }

  public void print(Object x) {
    System.out.print("Object-");
  }
}
