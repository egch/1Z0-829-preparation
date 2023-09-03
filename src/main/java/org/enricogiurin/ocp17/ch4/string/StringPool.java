package org.enricogiurin.ocp17.ch4.string;

public class StringPool {

  public static void main(String[] args) {
    new StringPool().intern();
  }

  void intern() {
    String s1 = "a";
    String s2 = "a";
    String s3 = new String("a");

    //true
    System.out.println(s1==s2);
    //false
    System.out.println(s1==s3);
    //true
    System.out.println(s1==s3.intern());
  }

}
