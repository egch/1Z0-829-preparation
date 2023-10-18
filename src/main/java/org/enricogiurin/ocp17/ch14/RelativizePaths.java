package org.enricogiurin.ocp17.ch14;

import java.nio.file.Path;

public class RelativizePaths {

  public static void main(String[] args) {
    new RelativizePaths().relativize();
  }

  //both P1 & P2 are relative
  void relativize() {
    Path path1 = Path.of("fish.txt");
    Path path2 = Path.of("friendly/birds.txt");
    //  ../friendly/birds.txt
    System.out.println(path1.relativize(path2));
    // ../../fish.txt
    System.out.println(path2.relativize(path1));
  }

  //both P1 & P2 are absolute
  void relativize_absolute() {
    Path path1 = Path.of("/tmp/fish.txt");
    Path path2 = Path.of("/user/friendly/birds.txt");
    //  ../friendly/birds.txt
    System.out.println(path1.relativize(path2));
    // ../../fish.txt
    System.out.println(path2.relativize(path1));
  }

  //The relativize() method requires both paths to be absolute or relative
  // and throws an exception if the types are mixed.
  void relativize_mixed() {
    //absolute
    Path path1 = Path.of("/tmp/fish.txt");
    //relative
    Path path2 = Path.of("birds.txt");
    //Exception in thread "main" java.lang.IllegalArgumentException: 'other' is different type of Path
    System.out.println(path1.relativize(path2));
  }

}
