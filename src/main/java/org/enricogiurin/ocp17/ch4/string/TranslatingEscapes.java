package org.enricogiurin.ocp17.ch4.string;

public class TranslatingEscapes {

  public static void main(String[] args) {
    new TranslatingEscapes().translating();
  }
  void translating() {
    String source = "1\\t2";
    //1\t2
    System.out.println(source);
    //1	2
    System.out.println(source.translateEscapes());
  }

}
