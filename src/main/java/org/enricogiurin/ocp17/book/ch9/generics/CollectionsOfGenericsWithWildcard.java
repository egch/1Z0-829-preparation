package org.enricogiurin.ocp17.book.ch9.generics;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class CollectionsOfGenericsWithWildcard {

  public static void addException(Collection<? super Throwable> coll) {
    //I can add any class whose superclass is Throwable
    coll.add(new RuntimeException());
    coll.add(new Exception());
    coll.add(new Throwable());
  }

  void extendsType() {

    //on the right side I can use any exceptions child of RTE
    Set<? extends RuntimeException> set1 = new HashSet<RuntimeException>();
    Set<? extends RuntimeException> set2 = new HashSet<NullPointerException>();

    Set<? extends RuntimeException> set3 = new TreeSet<RuntimeException>();
    Set<? extends RuntimeException> set4 = new TreeSet<ArithmeticException>();
  }

  void diamond() {
    //wrong!
    //The diamond operator `<>` cannot be used on the left side of the assignment.
    //List<> list = new ArrayList<>(); does not compile!
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

  void lowerBoundedWildcards() {
    List<? super IOException> exceptions = new ArrayList<Exception>();
    //exceptions can be a list of:
    //- IOException or any class having IOException as super
    exceptions.add(new IOException("error"));// yes we can add it
    exceptions.add(new FileNotFoundException("error"));// yes we can add it

    //we cannot add an Exception as it could be a list of IOException and Exception is not an IOException
    //exceptions.add(new Exception("error"))
  }

  void lowerBoundedWildcards2() {
    Collection<? super Exception> exList = new ArrayList<>();
    //here I can add everything is a child of Exception
    exList.add(new RuntimeException());
    exList.add(new Exception());
    //but I cannot add Error
    //exList.add(new Error());  does not compile

    Collection<? super RuntimeException> rteList = new ArrayList<>();
    //here I can add everything is a child of RuntimeException
    rteList.add(new RuntimeException());
    rteList.add(new IndexOutOfBoundsException());

    //but I cannot a generic Exception
    //rteList.add(new Exception());  //does not compile

    Exception ex = new RuntimeException();
    //rteList.add(ex); //not even like this because it's declared as Exception (in spite is a RTE)
  }

  void lowerBounded2() {
    List<? super RuntimeException> rteList = new ArrayList<Exception>();
    List<? super RuntimeException> rteList2 = new ArrayList<Throwable>();
    List<? super RuntimeException> rteList3 = new ArrayList<RuntimeException>();
    //Required type:
    //List
    //IllegalArgumentException is a child of RTE not one of its super classes!
    //List<? super RuntimeException> rteList4 = new ArrayList<IllegalArgumentException>();  //DOES NOT COMPILE
  }

  void lowerBoundedWildcards3() {
    //List<? super IOException> ioExceptions = new ArrayList<FileNotFoundException>();  //does not compile
    List<? super IOException> ioExceptions = new ArrayList<Exception>();  //does  compile
  }

  void wildcard() {
    //this means list of Object
    //I cannot add element on this list
    List<?> q = List.of("mouse", "parrot");
    //I cannot add elements on this list
    List<?> list2 = new ArrayList<String>();
    //list2.add(new Object()); does not compile
  }

  void var() {
    List<Integer> list = List.of(2, 5);
    List<Integer> mutableList = new ArrayList<>(list);
    //type inference: var is a List<String> from the right assignment
    var varList = new ArrayList<>(list);
    Integer first = varList.get(0);
    System.out.println(first);
  }

  void addElementToAListWithWildCard() {
    List<?> wildcardList = new ArrayList<String>();
    List<? extends IOException> listExtends = new ArrayList<FileNotFoundException>();
    List<? super IOException> listSuper = new ArrayList<Object>();
    //I cannot add a element to a list defined as List<?>
    //It means that the list can hold elements of an unknown type.
    // wildcardList.add("aa");  //does not compile!

    //this is also immutable
    //listExtends.add(new FileNotFoundException())  //does not compile

    listSuper.add(new FileNotFoundException()); //this compiles
  }

  void wrongCollectionWithGenerics() {
    //does not compile
    //List<String> strings = new ArrayList<?>();
  }


}
