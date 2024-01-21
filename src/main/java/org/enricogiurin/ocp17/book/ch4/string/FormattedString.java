package org.enricogiurin.ocp17.book.ch4.string;

public class FormattedString {

  public static void main(String[] args) {
    new FormattedString().formattedWithNL();
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

  void formattedWithNL() {
    //%n = new ling
    String template = """
        Hello %nWorld""";
    //Hello
    //World
    System.out.println(template.formatted());
  }


}
