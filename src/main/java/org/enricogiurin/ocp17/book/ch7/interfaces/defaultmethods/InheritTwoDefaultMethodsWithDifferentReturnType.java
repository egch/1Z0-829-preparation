package org.enricogiurin.ocp17.book.ch7.interfaces.defaultmethods;

interface Chair {

  default String getSKU() {
    return "1";
  }
}

interface Desk {

  default int getSKU() {
    return 1;
  }
}

//This class cannot implement both these 2 interfaces as they have the same default method
// but with different return type
public class InheritTwoDefaultMethodsWithDifferentReturnType
    /**implements Chair, Desk */
{

}
