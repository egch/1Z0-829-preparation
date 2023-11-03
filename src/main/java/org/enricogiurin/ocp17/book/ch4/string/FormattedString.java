package org.enricogiurin.ocp17.book.ch4.string;

public class FormattedString {

  public static void main(String[] args) {
    new FormattedString().formatted();
  }

  void formatted() {
    String template = """
        Hello %s,
        Your order %d is ready!""";
    String formatted = template.formatted("Enrico", 123);
    //Hello Enrico,
    //Your order 123 is ready!
    System.out.println(formatted);
  }

}
