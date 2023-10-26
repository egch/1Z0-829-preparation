package org.enricogiurin.ocp17.ch4.string;

public class StringIndent {

  public static void main(String[] args) {
    new StringIndent().stripIndent();
  }

  void indent() {
    var block = """
        Today is a wonderful day
        even though it is raining""";
    //Today is a wonderful day
    //even though it is raining
    System.out.println(block);
    String ns = block.indent(2);
    //  Today is a wonderful day
    //  even though it is raining
    System.out.println(ns);
    // Today is a wonderful day
    // even though it is raining
    System.out.println(ns.indent(-1));
  }

  void stripIndent() {
    var text = " a\n"
        + "  b\n"
        + " c";

    System.out.println("Original Text:");
    System.out.println(text);
    System.out.println("length: " + text.length());

    String stripped = text.stripIndent();  //9

    System.out.println("\nStripped Text:");
    System.out.println(stripped);
    System.out.println("length: " + stripped.length()); //6
  }


}
