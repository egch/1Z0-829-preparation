package org.enricogiurin.ocp17.book.ch11.exceptions;


public class CatchExceptionNotThrown {

  void catchIoException() {
    try {
      doNothing();
    }
    //does not compile as IOException is never thrown
/*    catch (IOException e) {}*/
    finally {
      System.out.println("finally");
    }
  }

  void catchException() {
    try {
      doNothing();
      //I can catch Exception in spite is never thrown
    } catch (Exception e) {
    }
  }

  void catchError() {
    try {
      doNothing();
      //I can catch Error in spite is never thrown
    } catch (Error e) {
    }
  }

  void catchRuntimeException() {
    try {
      doNothing();
      //I can catch RuntimeException in spite is never thrown
    } catch (RuntimeException e) {
    }
  }
  void doNothing(){}

}
