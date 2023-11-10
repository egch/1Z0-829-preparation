package org.enricogiurin.ocp17.book.ch9.generics;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
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

  void upperBoundedWildcards() {
    List<? extends Number> listOfInteger = new ArrayList<Integer>();
    //we cannot add any element to the list...as we do not know
    //if a list of Integer or AtomicInteger and so on

    //does not compile...what if is a list of AtomicInteger
    //listOfInteger.add(new Integer(3));

    //does not compile...what if is a list of Integer
    //listOfInteger.add(new AtomicInteger(2));

    List<? extends Number> list = new ArrayList<>();

    //the same goes with this
  }


    public static void addException(Collection<? super Throwable> coll) {
      //I can add any class whose superclass is Throwable
      coll.add(new RuntimeException());
      coll.add(new Exception());
      coll.add(new Throwable());
    }


  void lowerBoundedWildcards() {
    List<? super IOException> exceptions = new ArrayList<Exception>();
    //exceptions can be a list of:
      //- IOException or any class having IOException as super
    exceptions.add(new IOException("error"));// yes we can add it
    exceptions.add(new FileNotFoundException("error"));// yes we can add it

    //we cannot add an Exception as it could be a list of IOException and Exception is not an IOException
    //exceptions.add(new Exception("error"))

  }

  void wildcard() {
    //this means list of Object
    //I cannot add element on this list
    List<?> q = List.of("mouse", "parrot");
    //I cannot add element on this list
    List<?> list2 = new ArrayList<String>();
  }

  void wrongCollectionWithGenerics() {
    //does not compile
    //List<String> strings = new ArrayList<?>();
  }



}
