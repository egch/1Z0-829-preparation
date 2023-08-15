package org.enricogiurin.ocp17.crashcourse.textblock;

public class Ex1 {

  public static void main(String[] args) {
    String message = """
        Hello\
        Java 17 World!""";
    System.out.println("XXX" + message + "XXX");

    System.out.println("------------");
    String message2 = """
             ""\"""\"""Hello", he said
        Java 17 World!
        """;
    System.out.println(message2 + "XXX");

  }
}
