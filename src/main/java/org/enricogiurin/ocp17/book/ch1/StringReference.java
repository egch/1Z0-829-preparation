package org.enricogiurin.ocp17.book.ch1;


//How many objects are eligible for garbage collection at the end of the main() method?
//two: s3 as it lives in the scope of check
//"s2" as it's no longer referenced
public class StringReference {

  static String s1 = new String("s1");
  static String s2 = new String("s2");

  public static void main(String... args) {
    new StringReference().check();
  }

  public void check() {
    String s3 = new String("s3");
    s2 = s1;
    s1 = s3;
  }
}