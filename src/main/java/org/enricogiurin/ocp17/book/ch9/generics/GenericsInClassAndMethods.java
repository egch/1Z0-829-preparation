package org.enricogiurin.ocp17.book.ch9.generics;

public class GenericsInClassAndMethods {

  public static void main(String[] args) {
    new GenericsInClassAndMethods().usage();
  }

  void usage() {
    Hello<String> java = new Hello<>("hello");
    java.message("World");  //hello World
    //here the arg is only String, which is, the type of Hello record
    //java.message(12); //DOES NOT COMPILE

    //in this case I set the T of message2 as type Integer
    java.message2(23);  //hello 23
    //extended version
    java.<Integer>message2(23);  //hello 23
  }

}


record Hello<T>(T t) {

  public Hello(T t) {
    this.t = t;
  }

  //here the T refers to the type defined int the record Hello
  public void message(T message) {
    System.out.println(this.t + " " + message);
  }

  //here the T is another generics type
  public <T> void message2(T message) {
    System.out.println(this.t + " " + message);
  }
}