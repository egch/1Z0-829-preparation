package org.enricogiurin.ocp17.book.ch4.string;

import org.enricogiurin.ocp17.various.helper.JarMockTest;

public class StringPool {

  public static void main(String[] args) {
    new StringPool().stringPool2();
  }

  void intern() {
    String s1 = "a";
    String s2 = "a";
    String s3 = new String("a");

    //true
    System.out.println(s1 == s2);
    //false
    System.out.println(s1 == s3);
    //true
    System.out.println(s1 == s3.intern());
  }

  @JarMockTest
  void forCycle() {
    String country = "Italy";
    String result = "";
    char[] chars = {'I', 't', 'a', 'l', 'y'};
    for (char c : chars) {
      result = result + c;
    }
    System.out.println(result == country);  //false
    System.out.println(result.equals(country));  //true
  }

  void stringPool() {
    String ciao = "ciao";
    String ciao2 = "c" + "i" + "a" + "o";
    String ciao3 = "c";
    ciao3 = ciao3 + "i";
    ciao3 = ciao3 + "a";
    ciao3 = ciao3 + "o";

    System.out.println(ciao2 == ciao); //true
    System.out.println(ciao.equals(ciao2));//true

    System.out.println(ciao3 == ciao); //false
    System.out.println(ciao.equals(ciao3));//true
  }

  void stringPool2() {
    String s1 = "ab";
    String s2 = "a" + "b";
    System.out.println(s1 == s2);  //true
    String s3 = "a";
    s3 += "b";
    System.out.println(s1 == s3);  //false
  }

}
