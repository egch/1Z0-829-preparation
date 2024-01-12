package org.enricogiurin.ocp17.book.ch8.functionalinterface.jdk.primitive.mixed;

import java.util.function.ObjLongConsumer;

public class UsageOfObjLongConsumer {

  public static void main(String[] args) {
    new UsageOfObjLongConsumer().anonymous();
  }

  void usage() {
    ObjLongConsumer<String> objLongConsumer = (String s, long l) -> System.out.println(s+": "+l);
    objLongConsumer.accept("Number", 10L);  //Number: 10
  }

  void anonymous() {
    ObjLongConsumer<Integer> instance = new ObjLongConsumer<>() {
      @Override
      public void accept(Integer integer, long value) {
        //Integer: 10 - long: 20
        System.out.println("Integer: %d - long: %d".formatted(integer, value));
      }
    };
    instance.accept(10, 20);
  }

}
