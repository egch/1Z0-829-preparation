package org.enricogiurin.ocp17.ch5;

public class OverloadingBoxing {

  public static void main(String[] args) {
    OverloadingBoxing instance = new OverloadingBoxing();
    //primitive: 4
    instance.print(4);
    //Wrapper: 4
    instance.print(Integer.valueOf(4));
    //long: 4
    instance.print(Long.valueOf(4L));
    //long: 4
    instance.print(4L);
  }

  void print(int x) {
    System.out.println("primitive: "+x);
  }
  void print(Integer x) {
    System.out.println("Wrapper: "+x);
  }

  void print(long x) {
    System.out.println("long: "+x);
  }


}
