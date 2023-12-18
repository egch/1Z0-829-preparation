package org.enricogiurin.ocp17.book.ch7.nested.local;

public class LocalAbstractNestedClass {

  public static void main(String[] args) {
    new LocalAbstractNestedClass().message();
  }
  void message() {
    //abstract local nested class
    abstract  class Format {
      String indent(String message) {
        return message.indent(1);
      }
      abstract String desc();

    }//end of Format
    Format instanceFormat = new Format(){

      @Override
      String desc() {
        return "indent message of one";
      }
    };
    String message = instanceFormat.indent("""
        Hello girls \
        I'm here!""");
    System.out.println(message);
  }

}
