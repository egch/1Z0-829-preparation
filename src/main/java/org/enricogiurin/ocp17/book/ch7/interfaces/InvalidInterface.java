package org.enricogiurin.ocp17.book.ch7.interfaces;

/**
 * all classes extend from Object, you cannot declare an
 * interface method that is incompatible with Object.
 */
public interface InvalidInterface {
  @Override
  String toString();

  //attempting to use an incompatible return type
  //int toString();  //does not compile


}
