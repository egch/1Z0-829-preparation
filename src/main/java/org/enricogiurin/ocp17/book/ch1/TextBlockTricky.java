package org.enricogiurin.ocp17.book.ch1;

public class TextBlockTricky {

  private int numForks;

  public static void main(String[] args) {
    new TextBlockTricky().whitespace();

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





}