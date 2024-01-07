package org.enricogiurin.ocp17.book.ch1;

import org.enricogiurin.ocp17.various.helper.Enthuware;

public class TextBlocks {

  public static void main(String[] args) {
    new TextBlocks().backslash();
        /*
        starts with """ and ends with """
        text blocks requires a break between beginning and the end
        example:
        String s = """aaa"""; //does not compile
         */
    //printPyramid();
    //countLines();

  }

  void printTextBlock() {
    String s = """
        Today is thursday
        and I guess tomorrow is friday
        """;
    System.out.println(s);

    /*
    output:

    Today is thursday
    and I guess tomorrow is friday
     */
  }

  void printPyramid() {
    String pyramid = """
            *
           * *
          * * *
         * * * *
        * * * * *
            """;
    System.out.println(pyramid);
  }

  //will print only 2 line as there is a backslash
  void countLines() {
    var block = """ 
        squirrel \s
        pigeon \
        termite""";
    System.out.print(block);
  }

  void textBlock() {
    String s = """
        I do not want a newline \
        This should be in the same line
        """;
    System.out.println(s);
  }

  void anotherTextBlock() {
    String textBlock = """
        This is a text block
        """;
    System.out.println(textBlock);
  }

  void equivalentTextBlock() {
    var quotes = """
          \"The Quotes that Could\"
        \"\"\"
         """;

    var equivalent = """
          "The Quotes that Could"
        \"""
         """;
    System.out.println(equivalent);
  }

  void whiteSpace() {
    var block = """
    green
      yellow
    """;
    System.out.println("#"+block+"#");
  }

  @Enthuware
    //backslash: \
  void backslash() {
    //the char backslash is ignored
    var digits = """
        01234\
        56789""";
    String s5678 = digits.substring(5, 9);
    System.out.println(s5678);  //5678
  }

}
