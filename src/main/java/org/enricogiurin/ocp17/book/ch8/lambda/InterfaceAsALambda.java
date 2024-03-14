package org.enricogiurin.ocp17.book.ch8.lambda;

import java.util.List;

public class InterfaceAsALambda {

  public static void main(String[] args) {
    new InterfaceAsALambda().callLambda();
  }

  void callAnonymous() {
    Student student = new Student() {
      @Override
      public void study(Book book) {
        System.out.println("studying book: " + book.title());
      }
    };
    List<Book> books = List.of(new Book("ocp 17"),
        new Book("ocp 11"));
    books.forEach(book -> student.read(book));
  }

  void callLambda() {
    Student student = b -> System.out.println("[lambda]: " + b);
    List<Book> books = List.of(new Book("ocp 17"),
        new Book("ocp 11"));
    books.forEach(b -> student.study(b));
  }

  @FunctionalInterface
  interface Student {

    default void read(Book b) {
      System.out.println("reading book: " + b.title());
    }

    void study(Book book);
  }

  record Book(String title) {

  }

}
