package org.enricogiurin.ocp17.book.ch2;

import java.util.Collection;

public class UsageOfInstanceof {

  public static void main(String[] args) {
    new UsageOfInstanceof().nullInstanceof();
  }


  void usage() {
    Exception exception = new Exception();
    Throwable t = new Throwable();
    String s = "hello";
    if (exception instanceof Throwable) {
      System.out.println("It's an instance of Throwable");
    }
    if (exception instanceof Exception) {
      System.out.println("It's an instance of Exception");
    }

    //this won't compile
    /*
    if(s instanceof Throwable){
                System.out.println("It's an instance of Throwable");
            }
    */
  }

  void invalidInstanceof() {
    Integer number = 5;
    //invalid instanceof...number cannot be a string
    /*
      if(number instanceof  String){
          //
        }
    */

    //but this is valid
    Object n2 = 5;
    if (n2 instanceof String) {
      //
    }
  }

  void nullInstanceof() {
    //this always returns false!
    if (null instanceof String) {
      System.out.println("It's null");
    } else {
      System.out.println("It's not");
    }
    Object object = new String("A");
    //this does not compile!
    // if(object instanceof null){}

  }

  void instanceofScope() {
    Object fish = "fish";

    if (!(fish instanceof String guppy)) {
      System.out.print("Eat!");
      return;
    }
    //here I can access to guppy...because If I am here
    //that means that fish is an instance of String!
    System.out.println(guppy);

    //Based on flow scoping, guppy is in scope after lines if the type is not a String.
    // In this case, the next line declares a variable guppy that is a duplicate of the
    // previously defined local variable defined on line 41.

    //TODO - review this
    /*    else if (!(fish instanceof String guppy)) {
            throw new RuntimeException();
     }*/
    System.out.print("Swim!");
  }

  void instanceof_interface() {
    Number number = Integer.valueOf(5);
    if (number instanceof Integer) {
      System.out.println("It's an Integer");
      return;
    }
    //Number can never be an instance of String
    //so the following block does not compile
/*
    if(number instanceof  String) {
      //invalid
    }
*/
    //each class can be in theory an instance of any Interface
    /*
    The compiler can't definitively state that number is not a Collection.
    Some future program could create a subclass of Number that does implement Collection.
     */
    if (number instanceof Collection) {
      System.out.println("unreal but it compiles");
    }
  }

  void instanceofWithVar() {
    Object obj = 10;
    var result = obj instanceof String;
    boolean result2 = obj instanceof String;
  }

}

