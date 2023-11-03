package org.enricogiurin.ocp17.book.ch9;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Questions {

  public static void main(String[] args) {
    new Questions().genericsWIthVar();
  }

  void genericsWithWildCard() {
    //with this the list is done of objects
    List<?> q = List.of("mouse", "parrot");
    //does not compile as the type is Object and there aint't isEmpty/length method
    //q.removeIf(String::isEmpty);
    //q.removeIf(s -> s.length() == 4);

  }

  void genericsWIthVar() {
    //v inferred type is List<String>
    var v = List.of("mouse", "parrot");

    //these 2 trigger a runtime exception as List.of creates an immutable list
    //Exception in thread "main" java.lang.UnsupportedOperationException
    v.removeIf(String::isEmpty);
    v.removeIf(s -> s.length() == 4);
  }

  void upperBounds() {
    Map<String, ? extends Number> map = new HashMap<String, Integer>();
    //I can't add any value to this map
    //map.put("ciccio", 2);

  }
}
