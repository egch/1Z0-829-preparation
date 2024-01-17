package org.enricogiurin.ocp17.book.ch9;

import java.util.ArrayList;
import java.util.List;

public class RemoveFromList {

  public static void main(String[] args) {
    new RemoveFromList().anotherTricky();
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


  void anotherTricky() {
    var integer = new ArrayList<Integer>(List.of(2, 7, 1, 8));
    var longs = new ArrayList<Long>(List.of(2L, 7L, 1L, 8L));

    //calling remove(int index)
    integer.remove(1); //[2,1,8]
    //calling remove(Object value)
    longs.remove(1L);   //[2L, 7L, 8L]

    var values = new ArrayList<Integer>();
    values.add(2);
    values.add(7);
    values.add(1);
    values.add(8);
    //calling remove(int index)
    values.remove(1);  //[2,1,8]

    System.out.println(integer); //[2, 1, 8]
    System.out.println(longs); //[2, 7, 8]
    System.out.println(values); //[2, 1, 8]
  }

}
