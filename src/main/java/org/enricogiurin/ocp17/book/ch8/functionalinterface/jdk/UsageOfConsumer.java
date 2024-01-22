package org.enricogiurin.ocp17.book.ch8.functionalinterface.jdk;

import java.util.function.Consumer;

public class UsageOfConsumer {

  public static void main(String[] args) {
    new UsageOfConsumer().andThen();
  }

  void consume() {
    Consumer<String> consumer = (s) -> {
      if (s.length() > 3) {
        System.out.println(s);
      } else {
        System.out.println("too short");
      }
    };
    //too short
    consumer.accept("22");
  }

  void andThen() {
    Consumer<String> c1 = s -> System.out.println(s);
    Consumer<String> c2 = s -> System.out.println(s.length());
    Consumer<String> all = c1.andThen(c2);
    //123
    //3
    all.accept("123");
  }

}
