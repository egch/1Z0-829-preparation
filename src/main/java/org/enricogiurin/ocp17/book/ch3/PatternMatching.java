package org.enricogiurin.ocp17.book.ch3;

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
      //here s is defined as the first of condition is wrong
      System.out.println(s);
    }

    //You CANNOT access the pattern variable `s` here
    //System.out.println(s);
  }

  void firstIfFalse(Object object) {
    if (!(object instanceof String s)) {
      //here then s is NOT a String
      return;
    }
    //then here it is!. Mind the return first if
    System.out.println("length of string: " + s.length());
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
    //strange behavior for interface!
    if (t instanceof List list) {
      System.out.println("that's weird");
    }
  }

  void instanceofWIthPrimitives(Object x) {
    //not allowed primitive types with instanceof
/*
    if(x instanceof int){
          System.out.println("it's an int!");
    }
*/
    //but this is allowed
    if (x instanceof Integer) {
      System.out.println("it's an int!");
    }
  }

  void flowScoping(Number number) {
    //it cannot make sure data is an integer
    //does not compile
/*
    if(number instanceof Integer data || data.compareTo(5)>0){
    }
*/

    //this is fine as it's a logical and
    if (number instanceof Integer data && data.compareTo(5) > 0) {

    }

    //this is not fine as it is short-circuit logical and: both of the parts need to be evaluated
    //does not compile! (bitwise AND Operator)
    /*  if(number instanceof Integer data & data.compareTo(5)>0){}*/

  }
}
