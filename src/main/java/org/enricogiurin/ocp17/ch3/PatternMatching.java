package org.enricogiurin.ocp17.ch3;

import java.util.List;

public class PatternMatching {

  public static void main(String[] args) {
    new PatternMatching().pattern("Hello");
  }


  void pattern(Object object) {
    if (object instanceof String s) {
      System.out.println("length of string is " + s.length());
    }
  }

  void accessingOutOfScope(Object object) {
    if (!(object instanceof String s) || s.equals("enrico")) {
      System.out.println("bye bye");
    } else {
      System.out.println(s);
    }

    //You CANNOT access the pattern variable `s` here
    //System.out.println(s);
  }

  void notCompatible(Throwable t) {
    if (t instanceof Exception e) {
      System.out.println(e.getMessage());
    }
    //type not compatible
    /*
    if(t instanceof String s) {

    }
    */
    //strange behaviour for interface!
    if (t instanceof List list) {
      System.out.println("that's weird");
    }
  }

  void flowScoping(Number number) {
    //it cannot make sure data is an integer
    //does not compile
/*    if(number instanceof Integer data || data.compareTo(5)>0){

    }*/

    //this is fine as it's a logical and
    if (number instanceof Integer data && data.compareTo(5) > 0) {

    }

    //this not fine as it is a short-circuit logical and: both of the parts needs to be evaluated
    //does not compile!
/*    if(number instanceof Integer data & data.compareTo(5)>0){

    }*/

  }
}
