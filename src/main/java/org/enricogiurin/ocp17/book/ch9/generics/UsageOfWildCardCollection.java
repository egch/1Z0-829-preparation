package org.enricogiurin.ocp17.book.ch9.generics;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class UsageOfWildCardCollection {

  void left() {
    Collection<?> c1 = new ArrayList<>();
    Collection<?> c2 = new ArrayList<String>();
  }

  void arg() {
    class ArgUsage {

      void process(List<?> list) {
        Object o = list.get(0);
      }
    }
    ArgUsage argUsage = new ArgUsage();
    argUsage.process(new ArrayList<String>());
  }

}
