package org.enricogiurin.ocp17.book.ch11.exceptions;

public class ReturningAnException {
  //I couldn't believe but this does compile!
  Exception handle(RuntimeException e) {
    throw e;
  }

}
