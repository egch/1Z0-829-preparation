package org.enricogiurin.ocp17.book.ch6.abstractclass;

public abstract class AnAbstractClass {

  abstract void hello();
  //Illegal combination of modifiers: 'abstract' and 'private'
  //private abstract void notAllowed();

  //Illegal combination of modifiers: 'final' and 'abstract'
  //abstract final void notAllowed();

  //Illegal combination of modifiers: 'abstract' and 'static'
  //abstract static void notAllowed();

  //Modifier 'abstract' not allowed here
  // abstract AnAbstractClass(){}

}
