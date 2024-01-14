package org.enricogiurin.ocp17.book.ch8.functionalinterface.jdk.primitive.mixed;

import java.util.function.ObjIntConsumer;

public class UsageOfObjIntConsumer {

  public static void main(String[] args) {
    new UsageOfObjIntConsumer().anonymous();
  }
  void use() {
    ObjIntConsumer<String> objIntConsumer = (String s, int t)-> System.out.println(s.formatted(t));
    //There are 20 people in the room
    objIntConsumer.accept("There are %d people in the room", 20);
  }

  void anonymous() {
    ObjIntConsumer<String> objIntConsumer = new ObjIntConsumer<>() {
      @Override
      public void accept(String s, int value) {
        System.out.println(s.length() == value);
      }
    };
    objIntConsumer.accept("hello", 5); //true
    objIntConsumer.accept("hello", 4); //false
  }

}
