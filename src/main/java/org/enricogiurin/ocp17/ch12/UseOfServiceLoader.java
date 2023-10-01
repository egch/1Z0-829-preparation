package org.enricogiurin.ocp17.ch12;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ServiceLoader;
import java.util.ServiceLoader.Provider;
import java.util.stream.Stream;

public class UseOfServiceLoader {

  void load() {
    List<Dog> all  = new ArrayList<>();
    //here it's using the iterator of ServiceLoader
    for (Dog current : ServiceLoader.load(Dog.class))
      all.add(current);
  }

  void equivalentLoad() {
    ServiceLoader<Dog> serviceLoader = ServiceLoader.load(Dog.class);
    Iterator<Dog> iterator = serviceLoader.iterator();
    Stream<Provider<Dog>> stream = serviceLoader.stream();
    List<Dog> all = stream
        // here it's using a Stream of Provider
        .map(Provider::get)
        .toList();
  }

  static class Dog {}

}
