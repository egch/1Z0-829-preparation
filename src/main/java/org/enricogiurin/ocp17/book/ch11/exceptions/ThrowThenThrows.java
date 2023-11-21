package org.enricogiurin.ocp17.book.ch11.exceptions;

//let's see which exceptions we need to declare in the method signature (throws clause)
//when they are thrown in the method body.
public class ThrowThenThrows {


  //we need to declare the Exception in the method signature
  void throwException() throws Exception {
    throw new Exception();
  }

  //we do not need to declare the RuntimeException in the method signature
  void throwRuntimeException() {
    throw new RuntimeException();
  }

  //we do not need to declare the Error in the method signature
  void throwError() {
    throw new Error();
  }

  void throwInFinally() throws Exception {
    try {

    } finally {
      throw new Exception("finally");
    }
  }


}
