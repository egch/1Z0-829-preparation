package org.enricogiurin.ocp17.ch4;

public class UseOfStringBuilder {

  public static void main(String[] args) {
    new UseOfStringBuilder().withStringBuilder();
  }
  void notEfficient() {
    //This sequence of events continues, and after 26 iterations through the loop,
    // a total of 27 objects are instantiated,
    // most of which are immediately eligible for garbage collection.
    String target = "";
    for(char c='a'; c<='z';c++){
      target +=c;
    }
    //abcdefghijklmnopqrstuvwxyz
    System.out.println(target);
  }

  void withStringBuilder() {
    //this doesn't create intermediate string(s)
    StringBuilder target = new StringBuilder();
    for(char c='a'; c<='z';c++){
      target.append(c);
    }
    //abcdefghijklmnopqrstuvwxyz
    System.out.println(target);
  }

}
