package org.enricogiurin.ocp17.book.ch14;

import java.nio.file.Path;
import java.nio.file.Paths;

public class UsageOfSubPath {

  public static void main(String[] args) {
    new UsageOfSubPath().example();
  }

  void subPath() {
    Path pom = Path.of("pom.xml").toAbsolutePath();
    //  /Users/enrico/github/ocp17/1Z0-829-preparation/pom.xml
    System.out.println("path: " + pom);
    //6
    System.out.println("size of names: " + pom.getNameCount());
    //Users/enrico/github
    System.out.println("sub-path[0,3]: " + pom.subpath(0, 3));

    //github/ocp17/1Z0-829-preparation/pom.xml
    System.out.println("sub-path[2,3]: " + pom.subpath(2, 3));

    try {
      //it's start inclusive, end exclusive so there ain't sub-path from 2 to 1
      pom.subpath(2, 2);
    } catch (IllegalArgumentException e) {
      System.err.println(e.getMessage());
    }
  }

  void subPath2() {
    var p2 = Paths.get("/zoo/animals/bear/koala/food.txt");
    //                       0     1      2    3     4
    System.out.println(p2.subpath(1, 3).getName(1));
  }


  //subpath() is Zero-based indexing
  void normalize() {
    Path source = Path.of("stars/./rocks/../m1.meteor");
    for (int j = 0; j < source.getNameCount(); j++) {
      System.out.println("sub-path: "+source.subpath(j, j+1));
    }
    //sub-path: stars
    //sub-path: .
    //sub-path: rocks
    //sub-path: ..
    //sub-path: m1.meteor

    Path halleysComet = source
        .subpath(1, 5);
    System.out.println("halleysComet: %s".formatted(halleysComet));
    halleysComet = halleysComet.normalize();
    System.out.println("[normalize] halleysComet: %s".formatted(halleysComet));
    Path lexellsComet = Paths.get("./stars/../solar/");
    System.out.println("lexellsComet: %s".formatted(lexellsComet));
    //this value is not assigned then lost
    lexellsComet.subpath(1, 3)
        .resolve("m1.meteor").normalize();
    System.out.print(halleysComet.equals(lexellsComet) ?
        "Same!" : "Different!");
  }

  void example() {
    Path original = Path.of("stars/./rocks/../m1.meteor");
    var path = original
        .subpath(1, 5).normalize();
    System.out.println(path);  //m1.meter

    int nameCount = original.getNameCount();
    for (int j = 0; j < nameCount; j++) {
      System.out.println(original.subpath(j, j + 1));
    }
    System.out.println();
    for (int j = 0; j < nameCount; j++) {
      System.out.println(original.subpath(0, j + 1));
    }
    /*
      stars
      stars/.
      stars/./rocks
      stars/./rocks/..
      stars/./rocks/../m1.meteor
     */

  }

}
