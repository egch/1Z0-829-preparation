package org.enricogiurin.ocp17.book.ch1;

public class TextBlockTricky {

  public static void main(String[] args) {
    new TextBlockTricky().backslash();

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


}