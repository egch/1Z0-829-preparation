package org.enricogiurin.ocp17.book.ch11.exceptions;


import java.io.IOException;
import org.enricogiurin.ocp17.crashcourse.casting.Ex;


//I can declare throws for any Exception in the method signature
//no matter if the method throws it or not
public class ThrowsExceptionNotThrown {

  void throwsException() throws Exception {
    doNothing();
  }

  void throwsIOException() throws IOException {
    doNothing();
  }

  void throwsRuntimeException() throws RuntimeException {
    doNothing();
  }

  void throwsError() throws Error {
    doNothing();
  }

  void throwsThrowable() throws Throwable {
    doNothing();
  }


  void doNothing(){}

}
