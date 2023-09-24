package org.enricogiurin.ocp17.ch11.exceptions;

import java.io.IOException;

public class WhichExceptionCanCatch {

  void catchError() {
    try {

    }catch (Error e) {}
  }

  void catchException() {
    try {
      throwingClassCastException();
    }catch (Exception e) {}
  }

  void catchThrowable() {
    try {

    }catch (Throwable e) {}
  }

  void catchRTE() {
    try {

    }catch (RuntimeException e) {}
  }

  void callMethod() {
    throwingClassCastException();

  }

  //Exception 'java.io.IOException' is never thrown in the corresponding try block
/*  void catchCustomCheckedException() {
    try {

    }catch (IOException e) {}
  }*/



  public void transform(String c) {
    try {
      rollOut();
    } catch (Exception e) {
    }
  }


  void throwingClassCastException() throws ClassCastException {} ;

  void rollOut() throws ClassCastException {}

  void throwingException() throws Exception {}

}
