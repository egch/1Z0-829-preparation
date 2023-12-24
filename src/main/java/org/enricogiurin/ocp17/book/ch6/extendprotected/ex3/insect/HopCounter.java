package org.enricogiurin.ocp17.book.ch6.extendprotected.ex3.insect;

public class HopCounter {
  public static void main(String[] args) {
    var hopper = new Grasshopper();
    hopper.move();

    /*
    hop() has protected access, and I am calling it from HopCounter:
     - HopCounter does not extend Hopper
     - it's in a different package
    */
   // hopper.hop();   //does not compile!
  } }
