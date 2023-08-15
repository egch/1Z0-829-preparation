package org.enricogiurin.ocp17.ch9.generics;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class CollectionsOfGenerics {

  void extendsType() {

    //on the right side I can use any exceptions child of RTE
    Set<? extends RuntimeException> set1 = new HashSet<RuntimeException>();
    Set<? extends RuntimeException> set2 = new HashSet<NullPointerException>();

    Set<? extends RuntimeException> set3 = new TreeSet<RuntimeException>();
    Set<? extends RuntimeException> set4 = new TreeSet<ArithmeticException>();

  }

}
