package org.enricogiurin.ocp17.book.ch11.exceptions;

import java.io.IOException;

public class CatchMethodWithThrows {
  void catchThrowingIOException() {
    try {
      throwingIOException();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  void throwsThrowingIOException() throws IOException {
    throwingIOException();
  }
  /*
  ************************
   */

  void catchThrowingException() {
    try {
      throwingException();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  void throwsThrowingException() throws Exception {
    throwingException();
  }


  void throwingIOException() throws IOException {}
  void throwingException() throws Exception {}
}
