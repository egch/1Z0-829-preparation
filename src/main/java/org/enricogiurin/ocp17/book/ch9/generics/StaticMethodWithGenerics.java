package org.enricogiurin.ocp17.book.ch9.generics;

public class StaticMethodWithGenerics {

  /**
   * Note that T declaration needs to be after static
   *
   * @param t
   * @param <T>
   */
  public static <T extends Number> void calculate(T t) {
    System.out.println(t);
  }

  //Does not compile because static comes after generics declaration
  /*
  public  <T extends Number> static void wrong(T t){
    System.out.println(t);
  }

  */

}
