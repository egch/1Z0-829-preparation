package org.enricogiurin.ocp17.book.ch1.textblocks;

import org.enricogiurin.ocp17.various.helper.JarMockTest;

public class TextBlockTricky {

  public static void main(String[] args) {
    new TextBlockTricky().isValidTB();

  }

  void tricky() {
    int numKnives;
    //here is just a block text don't be confused by the use of numKnives!!
    System.out.print("""
        "# forks = " + numForks +
        " # knives = " + numKnives +
        # cups = 0""");
  }

  void whitespace() {
    var block = """

           green
             yellow
        """;
    System.out.println(block);
  }

  void backslash() {
    var quotes = """
        \"The Quotes that Could\" 
        \"\"\"
        """;
    System.out.println(quotes);

    var quotes2 = """
        \"The Quotes that Could\"
        """;
    System.out.println(quotes2);
  }

  @JarMockTest
  void isValidTB() {
    var tb = """\u0020\u0020\u0020\u0020\u0020\u0020\u0020\u0020
        """;
    System.out.println(tb.length());  //0

    var s = "\u0020";
    System.out.println(s.length());  //1
  }


}