package org.enricogiurin.ocp17.book.ch7.useofenum;

public class PassingEnumAsParameter {
  enum EU {
    ITALY, FRANCE, GERMANY
  }

  public  void print(EU country){
    System.out.println(country.name());
  }

  public static void main(String[] args) {
    PassingEnumAsParameter instance = new PassingEnumAsParameter();
    //I can't only pass the value of the enum
    //instance.print(ITALY); //does not compile

    //this works
    instance.print(EU.ITALY); //
  }

}
