package org.enricogiurin.ocp17.crashcourse.recordstuff;

// purpose is "immutable" data carrier (named tuples? with extras)
// accessor methods created for each "component"
// has name of the component with empty parens, throws no checked exceptions
// has the type of the component (if varags then array)
// components create final fields with the same name
// components cannot have the name of an Object method (e.g. wait, toString :)
// all records are subtypes of java.lang.Record, but MUST NOT use extends
// and are implicitly final
record Client(String name, int creditLimit) { // these two are "components"

  // line n1
  // not permitted to add any instance fields
//  private final int x = 99;
  // are permitted static fields, don't even have to be final
  private static int x;
  // are permitted instance, "overriding", and static methods

  // explicit canonical constructor, must not be less accessible
  // than the class (default canonical constructor has same access as class
  // MUST initialize the fields from the components
  // argument names MUST match the components!!!
//  public Client(String name, int credit) { // NOPE
  Client(String name, int creditLimit) {
//    super(); // NOPE! This must be left to the system
    // most likely reason to create explicit constructor would be
    // validation:
    if (name == null || name.length() == 0) {
      throw new IllegalArgumentException("bad name");
    }

    this.name = name;
    this.creditLimit = creditLimit;
//    this.creditLimit = credit; // this can't happen
  }

  // are allowed overloaded constructors
  // which are allowed to be less accessible?
  // all routes through construction MUST end up at the
  // canonical constructor (whichever form it took)
  // that's where the final fields are initialized
  private Client(String name) {
    this(name, 1000);
  }

  // because hand-coded constructor most likely just does validation,
  // we can define "compact constructor"
//  Client { // must not have both this compact AND explicit canonical
//    if (name == null || name.length() == 0) {
//      throw new IllegalArgumentException("bad name");
//    }
//    name = "Mr/Mrs/Ms/Mx " + name; // "Normalization"
//    // compact constructor MUST NOT mention the fields
//    // this code "runs into" the default canonical constructor :)
//  }

  @Override // Not really "overriding" -- it's replacing
  public String toString() {
//    return super.toString(); // NOPE, there is no super...
    return "I'm a client with credit " + creditLimit;
  }
}

public class Example {

  public static void main(String[] args) {
    Client c1 = new Client("Fred", 99);
    Client c2 = new Client("Fred", 99);
    Client c3 = new Client("Jim", 99);
    System.out.println(c1); // toString :)
    System.out.println(c1.name());
    System.out.println("equality");
    System.out.println(c1.equals(c2));
    System.out.println(c1.equals(c3));

    System.out.println("hashCodes");
    System.out.println(c1.hashCode());
    System.out.println(c2.hashCode());
    System.out.println(c3.hashCode());


  }
}
