package org.enricogiurin.ocp17.ch12;

import java.util.ArrayList;
import java.util.List;
import java.util.ServiceLoader;
import java.util.stream.Collectors;

import java.util.ServiceLoader.Provider;

public class UseOfServiceLoader {

  void load() {
    List<Dog> all  = new ArrayList<>();
    //here it's using the iterator of ServiceLoader
    for (Dog current : ServiceLoader.load(Dog.class))
      all.add(current);

  }

  void equivalentLoad() {
    List<Dog> all = ServiceLoader.load(Dog.class)
        .stream()
        // here it's using a Stream of Provider
        .map(Provider::get)
        .collect(Collectors.toList());
  }

  static class Dog {}

}
