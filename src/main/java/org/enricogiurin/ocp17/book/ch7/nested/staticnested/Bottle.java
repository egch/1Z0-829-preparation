package org.enricogiurin.ocp17.book.ch7.nested.staticnested;

public class Bottle {
  public static class Wrapper {
    private enum Gender {
      MALE, FEMALE
    }
    public Gender getGender() {
      return Gender.FEMALE;
    } }
  public static void main(String[] stars) {
    var bottle = new Bottle();
    //wrong way to instantiate a static nested class
    //does not compile
    //Wrapper q = bottle.new Wrapper();

    //correct way to instantiate a static nested class
    Wrapper q = new Wrapper();
    System.out.print(q.getGender());
  } }