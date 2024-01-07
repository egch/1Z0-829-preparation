package org.enricogiurin.ocp17.book.ch7.record;

public record CompactConstructorRecord(String firstName, String lastName, int age) {

  //this is a compact constructor
  //access modifiers should be the same as the record. In this case public
  public CompactConstructorRecord {  //no parenthesis
    if (firstName.isEmpty() || lastName.isEmpty()) {
      throw new IllegalArgumentException("invalid");
    }
    age = 30;

    //Cannot assign a value to final variable 'age'
    //compact constructor cannot modify fields
    //this.age = 40;  //does not compile!
  }


  //you can see that a record can contain a main
  public static void main(String[] args) {
    //throw Exception in thread "main" java.lang.IllegalArgumentException: invalid
    CompactConstructorRecord enrico =
        new CompactConstructorRecord("Enrico", "Giurin", 40);
    System.out.println(enrico);
  }


}
