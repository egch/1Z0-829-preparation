package org.enricogiurin.ocp17.book.ch1;

public class StringMethods {

  public static void main(String[] args) {
    new StringMethods().indent();
  }

  void indent() {
    String welcomeToThJungle = """
        Welcome to the jungle, we take it day by day
        If you want it you're gonna bleed but it's the price to pay
        And you're a very sexy girl who's very hard to please
        You can taste the bright lights but you won't get there for free
        In the jungle, welcome to the jungle
        Feel my, my, my, my serpentine
        Ooh, ah, I want to hear you scream
        """;
    System.out.println(welcomeToThJungle);
    //now with indent 2
    welcomeToThJungle = welcomeToThJungle.indent(2);
    System.out.println(welcomeToThJungle);

  }

}
