package org.enricogiurin.ocp17.ch5;

public class OverloadingVarargs {

  public static void main(String[] args) {
    OverloadingVarargs instance = new OverloadingVarargs();

    //in this case I call : two args
    instance.moo(2, new int[]{1});
    //in this case I call : one arg
    instance.moo(new int[]{1});
    //Ambiguous method call. DO not compile
    //instance.moo(3);
  }

  public void moo(int m, int... n) {
    System.out.println("two args");
  }

  private void moo(int... x) {
    System.out.println("one arg");

  }
}
