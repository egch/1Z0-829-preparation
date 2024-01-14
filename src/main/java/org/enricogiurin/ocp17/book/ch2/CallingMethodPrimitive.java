package org.enricogiurin.ocp17.book.ch2;

public class CallingMethodPrimitive {

  int returningALongAsAnInt(long x){
   // return x;  //does not compile!
    return (int)x;
  }

  long returningAnIntAsALong(int x){
    return x;
  }

}
