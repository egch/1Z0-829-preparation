package org.enricogiurin.ocp17.ch6;

import java.util.ArrayList;
import java.util.List;

//with final I prevent to have a mutable sub-class
public final class Immutable {
  //fields are private/final and no setter defined
  private final String name;
  private final List<Integer> list;

  public Immutable(String name, List<Integer> list) {
    this.name = name;
    //I make a copy of list passed in the constructor
    this.list = new ArrayList<>(list);
  }

  //no need to create a copy as string is immutable
  public String getName() {
    return name;
  }

  //I make a copy of the list
  public List<Integer> getList() {
    return new ArrayList<>(this.list);
  }

  public static void main(String[] args) {
    ArrayList<Integer> list = new ArrayList<>(List.of(1, 2, 3));
    Immutable enrico = new Immutable("enrico", list);
    //this is not affecting my instance
    list.add(1);
    System.out.println("name: "+enrico.name);
    //this is not affecting my instance
    enrico.getList().clear();
    enrico.getList().forEach(System.out::println);

  }
}
