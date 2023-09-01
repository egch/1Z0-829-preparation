package org.enricogiurin.ocp17.ch2;

public class UseOfInstanceOf {

  public static void main(String[] args) {
    new UseOfInstanceOf().usage();
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
    if(n2 instanceof  String){
      //
    }
  }

  void instanceOfScope() {
    Object fish = "fish";

    if (!(fish instanceof String guppy)) {
      System.out.print("Eat!");
    }
      //Based on flow scoping, guppy is in scope after lines if the type is not a String.
      // In this case, the next line declares a variable guppy that is a duplicate of the
      // previously defined local variable defined on line 41.

      //TODO - review this
/*    else if (!(fish instanceof String guppy)) {
        throw new RuntimeException();
     }*/
     System.out.print("Swim!");
  }

}

