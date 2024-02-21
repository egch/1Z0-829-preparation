package org.enricogiurin.ocp17.book.ch4.string;

public class TranslatingEscapes {

  public static void main(String[] args) {
    TranslatingEscapes instance = new TranslatingEscapes();
    instance.translating();
    instance.translateNL();
    System.out.println();
    instance.multiLines();
  }

  void translating() {
    String source = "1\\t2";
    //1\t2
    System.out.println(source);
    //1	2
    System.out.println(source.translateEscapes());
  }

  void translateNL() {
    String source = "Today is\\nSaturday";
    System.out.println(source); //Today is\nSaturday

    //Today is
    //Saturday
    System.out.println(source.translateEscapes());
  }

  void translating2() {
    //enrico is the\\\nbest
    String source = "enrico is the\\\\\\nbest";

    System.out.println(source);
    //enrico is the\
    //best
    System.out.println(source.translateEscapes());
  }

  void multiLines() {
    System.out.println("cheetah\ncub");
    //cheetah
    //cub
    System.out.println("cheetah\\ncub");
    //cheetah\ncub
    System.out.println("cheetah\ncub".translateEscapes());
    //cheetah
    //cub
    System.out.println("cheetah\\ncub".translateEscapes());
    //cheetah
    //cub
  }

}
