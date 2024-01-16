package org.enricogiurin.ocp17.book.ch4.string;

import static org.enricogiurin.ocp17.various.helper.TextHelper.wrap;

public class StringIndent {

  public static void main(String[] args) {
    new StringIndent().stripIndent2();
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


  void trickyIndent() {
    var phrase = "prickly \nporcupine";
    System.out.println(phrase);
    System.out.println();
    String pIndent1 = phrase.indent(1);
    System.out.println(pIndent1);
    System.out.println();
    String pIndent0 = phrase.indent(0);
    System.out.println(pIndent0);
    System.out.println();
    String indentMinus1 = phrase.indent(-1);
    System.out.println(indentMinus1);
    System.out.println();

    System.out.println(phrase.length());
    System.out.println(pIndent1.length());
    System.out.println(pIndent0.length());
    System.out.println(indentMinus1.length());
  }

  void stripIndent() {
    var text = "  a\n"
        + "       b\n"
        + "       c";

    System.out.println("Original Text:");
    System.out.println(text);
    System.out.println("length: " + text.length());

    String stripped = text.stripIndent();  //9

    System.out.println("\nStripped Text:");
    System.out.println(stripped);
    System.out.println("length: " + stripped.length()); //6
  }

  void stripIndent2() {
    var text = " a\n"
             + "       b\n"
             + " c";

    /*
< a
       b
 c>
     */
    System.out.println("Original Text:");
    System.out.println(wrap(text));
    var strippedText = text.stripIndent();

    System.out.println("\nStripped Text:");
    /*
<a
      b
c>
     */
    System.out.println(wrap(strippedText));
  }




  void indentBL() {
    var name = "1234 \n567";
    System.out.println("#%s#".formatted(name));
    //System.out.println(name.length());

    var indent1 = name.indent(1);
    System.out.println("#%s#".formatted(indent1));
    //System.out.println(indent1.length());

    var indent0 = name.indent(0);
    System.out.println("#%s#".formatted(indent0));
    //System.out.println(indent0.length());

    var indentMinus1 = name.indent(-1);
    System.out.println("#%s#".formatted(indentMinus1));
    //System.out.println(indentMinus1.length());
  }

  /*
#1234
567#
# 1234
 567
#
#1234
567
#
#1234
567
#

*/


}
