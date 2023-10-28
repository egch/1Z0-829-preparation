package org.enricogiurin.ocp17.practicetest.ch2;

public class CallingWithBoxed {
  public static void main(String[] args) {
    var instance = new CallingWithBoxed();
    instance.length("penguins");
    instance.length(5);
    instance.length(new Object());
  }
  public void length(Object obj) {
    if (obj instanceof String x)
      System.out.println(x.length());
  } }