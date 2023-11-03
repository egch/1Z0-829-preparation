package org.enricogiurin.ocp17.book.ch6;

public class ObjectInitializing {

  private static final int sf1;
  private static final int sf2 = 4;

  static {
    sf1 = 5;  //1)
  }

  private final int iF1;
  private final int iF2 = 4;
  private final int iF3;

  {
    iF1 = 2;  //2)
  }

  public ObjectInitializing(int iF3) {
    this.iF3 = iF3; //3)
  }

  public static void main(String[] args) {
    ObjectInitializing objectInitializing = new ObjectInitializing(5);
  }
}
