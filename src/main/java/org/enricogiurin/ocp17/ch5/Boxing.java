package org.enricogiurin.ocp17.ch5;

public class Boxing {

  public static void main(String[] args) {
    new Boxing().nullUnbox();
  }

  void boxing() {
    int age = 30;
    Integer wrapper = Integer.valueOf(age);
    int primitive = wrapper.intValue();
    //autoboxing
    wrapper = age;
    //unboxing
    primitive = wrapper;
  }

  void nullUnbox() {
    Integer wrapper = 30;
    wrapper = null;
    //Exception in thread "main" java.lang.NullPointerException:
    // Cannot invoke "java.lang.Integer.intValue()" because "wrapper" is null
    int primitive = wrapper;
  }

}
