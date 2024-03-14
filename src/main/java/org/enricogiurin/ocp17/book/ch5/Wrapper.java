package org.enricogiurin.ocp17.book.ch5;

public class Wrapper {

  public static void main(String[] args) {
    new Wrapper().increment();
  }

  void byteValue() {
    Integer.valueOf("10").byteValue();
    Long.valueOf("10").byteValue();
    Double.valueOf("10").byteValue();
    //the following line does not compile
    //Character.valueOf("10").byteValue();
  }

  void longToLong() {
    long lA = 2L;
    Long wrapper = 2L;
    long lb = 8;
    //Required type: //Long
    //Long wrapper2 = 8;  //DOES NOT COMPILE
  }

  void increment() {
    Integer x = 10;
    x++;
    int y = x;
    System.out.println(y);  //11
  }

  private void call() {
    Integer x = 5;
    handleInteger(x);
    handleInt(x);

    Short s = 4;
    //Required type: Integer
    //handleInteger(s); //does not compile!
    handleInt(s);

  }

  /*
   ******
   */

  void handleInteger(Integer x) {
    System.out.println("handling " + x);
  }

  void handleInt(int x) {
    System.out.println("handling " + x);
  }


}
