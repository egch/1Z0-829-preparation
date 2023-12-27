package org.enricogiurin.ocp17.book.ch9.generics;

public record AnotherRecordWithGenerics<T>(T t) {

  public AnotherRecordWithGenerics(T t) {
    this.t = t;
  }

  public static void main(String[] args) {
    AnotherRecordWithGenerics<String> hello = new AnotherRecordWithGenerics<>("Hello");
    AnotherRecordWithGenerics<Integer> data = new AnotherRecordWithGenerics<>(12);

    //warning - Raw use of parameterized class 'RecordWithGenerics'
    AnotherRecordWithGenerics inferred = new AnotherRecordWithGenerics("ciccio");
    //ciccio pasticcio
    inferred.println("pasticcio");
  }

  private <T> void println(T message) {
    System.out.print(t + "-" + message);
  }
}
