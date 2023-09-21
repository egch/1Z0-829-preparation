package org.enricogiurin.ocp17.ch11.exceptions;

import java.io.FileNotFoundException;
import java.io.IOException;

public class OverridingMethodsWithExceptions {

}

class Pet {
  void bau() throws IOException {}

  void eat() throws IOException {}
  void drink() throws IOException {}
}

class Dog extends Pet {


  //FileNotFoundException is a child of IOException
  @Override
  void bau() throws FileNotFoundException {}

  //here we chose to not declare any exception
  @Override
  void eat() {}

  //does not compile as An overridden method may not declare any
  // new or broader checked exceptions than the method it inherits
/*  @Override
  void drink() throws Exception{}
  */
}