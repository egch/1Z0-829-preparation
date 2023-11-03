package org.enricogiurin.ocp17.book.ch9.generics;

public record RecordWithGenerics<T>(T element) {

  public static void main(String[] args) {
    RecordWithGenerics<String> hello = new RecordWithGenerics<>("Hello");
    String result = hello.element();
    System.out.println(result);

    RecordWithGenerics<String> empty = new RecordWithGenerics<>(null);
    //throws RTE
    empty.element();

  }

  @Override
  public T element() {
    if (element == null) {
      throw new IllegalArgumentException("element is null");
    }
    return element;

  }
}
