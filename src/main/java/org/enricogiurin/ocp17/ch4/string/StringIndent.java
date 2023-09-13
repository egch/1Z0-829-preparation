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
    String html = """
                      <html>
                         <body>
                             <p>Hello, world</p>
                         </body>
                      </html>
        """;
    System.out.println(html);
    System.out.println(html.stripIndent());

  }

}
