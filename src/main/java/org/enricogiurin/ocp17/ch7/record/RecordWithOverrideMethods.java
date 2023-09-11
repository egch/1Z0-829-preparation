package org.enricogiurin.ocp17.ch7.record;

public record RecordWithOverrideMethods(int first, int second) {


  //I can define static fields
  private static int size = 10;
  public static int weight = 50;
  @Override
  public int first(){
    return first % 2;
  }

  public int second() {
    return second % 2;
  }

  @Override
  public String toString() {
    return "RecordWithOverrideMethods{" +
        "first=" + this.first() +
        ", second=" + this.second() +
        '}';
  }

  public static void main(String[] args) {
    RecordWithOverrideMethods re = new RecordWithOverrideMethods(5, 7);
    //RecordWithOverrideMethods{first=1, second=1}
    System.out.println(re);
  }
}
