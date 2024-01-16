package org.enricogiurin.ocp17.book.ch9;

import java.util.ArrayList;

public class RemoveFromList {

  public static void main(String[] args) {
    new RemoveFromList().tricky();
  }

  void tricky() {
    //here we have a List of Object, as the type couldn't be deferred from var
    var list = new ArrayList<>();
    list.add(5);
    list.add(3);
    list.add(2);
    list.add(1); //[5,3,2,1]
    //this remove the element at index 2, because here we call remove(int index)
    list.remove(2); //[5,3,1]
    //this removes element 1 as here we call remove(Object obj)
    list.remove(Integer.valueOf(1)); //[5, 3]

    System.out.println(list);  //[5,3]
  }

}
