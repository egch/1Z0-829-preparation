package org.enricogiurin.ocp17.book.ch4.string;

public class BasicIndent {

  public static void main(String[] args) {
    new BasicIndent().indentOnATB();
  }

  /*
    1234
      1234

    size s: 4
    size indented: 7
 */
  //not on a TB
  void indentOnAString() {
    String s = "1234";
    String indented = s.indent(2); //it adds two space at the beginning and a new line
    System.out.println(s);
    System.out.println(indented);
    System.out.println("size s: %d".formatted(s.length()));
    System.out.println("size indented: %d".formatted(indented.length()));
  }

  /*
    1234
      1234

    size s: 4
    size indented: 7
*/
  //it behaves as the other method
  void indentOnATB() {
    String s = """
        1234""";
    String indented = s.indent(2); //it adds two space at the beginning and a new line
    System.out.println(s);
    System.out.println(indented);
    System.out.println("size s: %d".formatted(s.length()));
    System.out.println("size indented: %d".formatted(indented.length()));
  }

}
