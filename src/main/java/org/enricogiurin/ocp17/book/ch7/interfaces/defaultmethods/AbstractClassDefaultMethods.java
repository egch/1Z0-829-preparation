package org.enricogiurin.ocp17.book.ch7.interfaces.defaultmethods;


public class AbstractClassDefaultMethods {

  //The Message interface shares the same default method as the WarmMessage interface
  interface Message {

    default void hello() {
    }
  }

  //The Message interface shares the same default method as the WarmMessage interface
  interface WarmMessage {

    default void hello() {
    }
  }

  /**
   * This class, although it is abstract, is required to override the default method shared by the
   * two interfaces it implements
   */
  //note: the class is abstract but still it is required to override

  abstract class SayHello implements Message, WarmMessage {

    @Override
    public void hello() {
      //can be in this way
      Message.super.hello();
      //and/or in this way
      WarmMessage.super.hello();
      //and/or with a customized impl
      System.out.println("hello");
    }
  }

  //this class does not compile as it does not override the shared method
  //abstract class WrongMessage implements Message, WarmMessage {}  //does not compile


}
