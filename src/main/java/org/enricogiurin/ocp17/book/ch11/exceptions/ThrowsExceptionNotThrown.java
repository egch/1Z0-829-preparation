package org.enricogiurin.ocp17.book.ch11.exceptions;


import java.io.IOException;

/**
 * I can declare throws for any Exception in the method signature no matter if the method throws it
 * or not
 */

public class ThrowsExceptionNotThrown {

  void throwsException() throws Exception {
    throwingNothing();
  }

  void throwsIOException() throws IOException {
    throwingNothing();
  }

  void throwsRuntimeException() throws RuntimeException {
    throwingNothing();
  }

  void throwsError() throws Error {
    throwingNothing();
  }

  void throwsThrowable() throws Throwable {
    throwingNothing();
  }


  void throwingNothing() {
  }

}
