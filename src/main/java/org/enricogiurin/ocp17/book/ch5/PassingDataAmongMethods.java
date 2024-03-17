package org.enricogiurin.ocp17.book.ch5;

import java.util.HashMap;
import java.util.Map;

public class PassingDataAmongMethods {

  public static void main(String[] args) {
    PassingDataAmongMethods instance = new PassingDataAmongMethods();
    instance.callSetAnArrayToNull();
  }

  void callSum() {
    int a = 2;
    sum(a);
    //2
    System.out.println(a);
  }

  void callAddEntry() {
    HashMap<String, String> map = new HashMap<>();
    addEntry(map);
    //Zurich
    System.out.println(map.get("John"));
  }


  void callHandlingAnArray() {
    int[] myArray = new int[2];
    myArray[0] = 5;
    handlingAnArray(myArray);
    //5
    System.out.println(myArray[0]);
  }

  void callSetAnArrayToNull(){
    int[] array = {1,2};
    System.out.println(array[0]);
    setAnArrayToNull(array);
    System.out.println(array[0]);

  }

  /*
   ***** internal methods *****
   */
  private void handlingAnArray(int[] array) {
    //since array was assigned a new object, changes do not affect myArray (the caller)
    array = new int[2];
    array[0] = 1;
  }

  private void sum(int a) {
    //this has no effect -> passing by value
    a += 5;
  }

  private void addEntry(Map<String, String> map) {
    map.put("John", "Zürich");
    //this has no effect -> but the content of map is changed before
    map = null;
  }

  void setAnArrayToNull(int[] array) {
    array[0]=7;
    array=null;
  }


}
