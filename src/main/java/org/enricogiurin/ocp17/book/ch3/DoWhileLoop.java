package org.enricogiurin.ocp17.book.ch3;

public class DoWhileLoop {

  public static void main(String[] args) {
    new DoWhileLoop().doWhileWithoutBraces();
  }

  void scope() {
    //I can't omit braces with a do while loop
    do {
      int x = 0;
      System.out.println("ciao");
      //}while (x<=5)  x is out of scope here
    } while (2 <= 5);
  }

  void emptyBody() {
    int x = 10;
    do {
    } while (x-- > 5);
  }

  void doWhileWithoutBraces() {
    int x = 0;
    //since the body of do-while contains one line only I do not need to use braces
    do {
      System.out.println(x++);
    }
    while (x < 5);
  }


}
