package org.enricogiurin.ocp17.varie.sof;

import java.util.Set;
import java.util.TreeSet;

public class ArrayOfSet {
  class Recipient implements Comparable<Recipient> {
    private final String name;

    public Recipient(String name) {
      this.name = name;
    }
    public String getName() {
      return name;
    }
    @Override
    public int compareTo(Recipient o) {
      return 0;
    }
  }

  //not the proper way but otherwise it's hard
  void arrayOfSet(){
    @SuppressWarnings("unchecked")
    Set<Recipient>[] groupMembers = new TreeSet[100];
  }

}
