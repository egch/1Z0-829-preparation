package org.enricogiurin.ocp17.book.ch9;

import java.util.List;
import java.util.Set;

public class CreatingSetWithFactory {

  public static void main(String[] args) {
    CreatingSetWithFactory instance = new CreatingSetWithFactory();
    instance.setOf();
  }
  void copyOf() {
    List<String> azureCerts = List.of("az-900", "az-104", "az-204");
    //this takes a collection as parameter
    //this is an immutable set
    Set<String> set = Set.copyOf(azureCerts);
    //Exception in thread "main" java.lang.UnsupportedOperationException
    set.add("az-305");
  }

  void setOf() {
    //this is an immutable set
    //this takes a varargs as parameter
    Set<String> mySkillSet = Set.of("java", "azure", "ML");
    //Exception in thread "main" java.lang.UnsupportedOperationException
    mySkillSet.add("soft skill");
  }

}
