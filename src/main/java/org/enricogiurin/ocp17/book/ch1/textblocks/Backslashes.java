package org.enricogiurin.ocp17.book.ch1.textblocks;

public class Backslashes {

  public static void main(String[] args) {
    new Backslashes().removeBackslashes();
  }

  void removeBackslashes() {
    var quotes = """
        \"The Quotes that Could\"
        \"\"\"
        """;
    System.out.println(quotes);

    var quotesSimplified = """
        "The Quotes that Could"
        \"""
        """;
    //it prints the same
    System.out.println(quotesSimplified);
  }

}
