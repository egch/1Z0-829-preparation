package org.enricogiurin.ocp17.book.ch7.record;

/**
 * It's fine to have a record with varargs
 */
public record RecordWithVarargs(int... scores) {

  public RecordWithVarargs(int score) {
    this(new int[]{score});
  }

  public static void main(String[] args) {
    RecordWithVarargs record = new RecordWithVarargs(new int[]{});
    int[] results = record.scores();
  }

  @Override
  public int[] scores() {
    return this.scores;
  }


}
