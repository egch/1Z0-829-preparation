package org.enricogiurin.ocp17.book.ch12;

import java.util.ArrayList;
import java.util.List;
import java.util.ServiceLoader;
import java.util.ServiceLoader.Provider;

public class UseOfServiceLoader {

  void load() {
    List<Dog> all = new ArrayList<>();
    //here it's using the iterator of ServiceLoader
    for (Dog current : ServiceLoader.load(Dog.class)) {
      all.add(current);
    }
  }

  void stream() {
    //load ia a static method
    ServiceLoader<Dog> serviceLoader = ServiceLoader.load(Dog.class);
    //here I have a list of Provider
    //stream() is an instance method, so you need to have an instance of ServiceLoader at first
    List<Provider<Dog>> list = serviceLoader.stream()
        .toList();

    List<Dog> dogs = serviceLoader.stream()
        .map(dogProvider -> dogProvider.get())
        .toList();
  }

  void stream2() {
    List<Dog> list = ServiceLoader.load(Dog.class)
        .stream()
        .map(Provider::get)
        .toList();
  }

  static class Dog {

  }

}
