package org.enricogiurin.ocp17.book.ch9;

public record RecordWithGenerics<T>(T t) {

  public RecordWithGenerics(T t) {
    this.t = t;
  }

  public static void main(String[] args) {
    RecordWithGenerics<String> hello = new RecordWithGenerics<>("Hello");
    RecordWithGenerics<Integer> data = new RecordWithGenerics<>(12);

    //warning - Raw use of parameterized class 'RecordWithGenerics'
    RecordWithGenerics inferred = new RecordWithGenerics("ciccio");
    //ciccio pasticcio
    inferred.println("pasticcio");
  }

  private <T> void println(T message) {
    System.out.print(t + "-" + message);
  }
}
