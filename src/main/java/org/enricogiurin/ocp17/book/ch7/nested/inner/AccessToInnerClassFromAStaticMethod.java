package org.enricogiurin.ocp17.book.ch7.nested.inner;

public class AccessToInnerClassFromAStaticMethod {
   class Messenger  {
     void message(String s){
       System.out.println(s);
     }
   }

  public static void main(String[] args) {
     //cannot be referenced from a static context
    //new Messenger().message("hello");

    //I need an instance of the outer class
    Messenger messenger = new AccessToInnerClassFromAStaticMethod().new Messenger();
    messenger.message("hello");
  }

}
