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

  void catchThrowingException() {
    try {
      throwingException();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  void catchThrowingThrowable() throws Throwable {
    throwingThrowable();
  }

  void throwsThrowingException() throws Exception {
    throwingException();
  }

  void throwsThrowingIOException() throws IOException {
    throwingIOException();
  }


  private void throwingIOException() throws IOException {
  }

  private void throwingException() throws Exception {
  }

  private void throwingThrowable() throws Throwable {
  }


}
