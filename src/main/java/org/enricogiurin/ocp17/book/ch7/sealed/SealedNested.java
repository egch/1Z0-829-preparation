package org.enricogiurin.ocp17.book.ch7.sealed;


public class SealedNested {

  //no needs of permits as we are in the same file
  sealed class Pet {

    public final class Dog extends Pet {

    }
  }

}
