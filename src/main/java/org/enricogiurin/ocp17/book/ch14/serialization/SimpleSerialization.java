package org.enricogiurin.ocp17.book.ch14.serialization;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.Path;

public class SimpleSerialization {

  public static void main(String[] args) throws IOException, ClassNotFoundException {
    new SimpleSerialization().serializeAndDeserialize();
  }
  //nested static class

  public void serializeAndDeserialize() throws IOException, ClassNotFoundException {
    Path path = Path.of("/tmp/person.ser");
    Person instance = new Person(40, "Mark");
    instance.age = 35;

    //here we write - serialize
    try (OutputStream outputStream = Files.newOutputStream(path);  //low level output stream
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(
            outputStream); //intermediate output stream
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(
            bufferedOutputStream)) {  //high level output stream
      objectOutputStream.writeObject(instance);
    }
    //here we de-serialize
    try (InputStream inputStream = Files.newInputStream(path);  //low level input stream
        BufferedInputStream bufferedInputStream = new BufferedInputStream(
            inputStream); //intermediate input stream
        ObjectInputStream objectInputStream = new ObjectInputStream(
            bufferedInputStream)) {  //high level input stream
      Person instanceDeserialized = (Person) objectInputStream.readObject();
      System.out.println(instanceDeserialized.age + " "
          + instanceDeserialized.name);  //35-null  (name is transient)
    }
  }

  static class Person implements Serializable {

    private Integer age = 0;
    private transient String name;

    {
      age = 30;
      name = "John";
    }

    public Person(Integer age, String name) {
      this.age = age;
      this.name = name;
    }
  }
}
