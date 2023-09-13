package org.enricogiurin.ocp17.ch9;

import java.util.ArrayList;
import java.util.List;

public class CreateListWithConstructor {

  void create() {
    //empty constructor
    List<String> list1 = new ArrayList<>();

    //passing an existing list in the constructor
    List<String> list2 = new ArrayList<>(list1);

    final int size = 3;
    //specifying the initial number of slots in the ArrayList
    List<String> list3 = new ArrayList<>(size);
  }

  void usingVar() {
    //type is inferred by the right side
    var list = new ArrayList<String>();

    //it will create a list of Object
    var list2 = new ArrayList<>();


  }

}
