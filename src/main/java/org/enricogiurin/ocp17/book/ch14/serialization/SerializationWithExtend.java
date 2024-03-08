package org.enricogiurin.ocp17.book.ch14.serialization;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.Path;

public class SerializationWithExtend {

  public static void main(String[] args) throws IOException, ClassNotFoundException {
    new SerializationWithExtend().serializeAndDeserialize();

  }

  //During deserialization, Java calls the constructor of the first non-serializable parent.
  // In this case, the Bird constructor is called,
  void serializeAndDeserialize() throws IOException, ClassNotFoundException {
    Eagle eagle = new Eagle();
    //name: Bridget
    System.out.println("name: " + eagle.getName());
    System.out.println("age: " + eagle.getAge());
    serialize(eagle);
    System.out.println("Eagle serialized");
    //no-arg constructor of the first non-serializable parent class
    Eagle deserializeEagle = deserialize();
    //name: Matt
    System.out.println("name: " + deserializeEagle.getName());
    //age is not transient
    System.out.println("age: " + deserializeEagle.getAge());

  }

  private void serialize(Eagle eagle) throws IOException {
    Path dest = Path.of("/tmp", "Eagle.ser");
    try (ObjectOutputStream oos = new ObjectOutputStream(Files.newOutputStream(dest))) {
      oos.writeObject(eagle);
    }
  }

  private Eagle deserialize() throws IOException, ClassNotFoundException {
    Path source = Path.of("/tmp", "Eagle.ser");
    try (ObjectInputStream ois = new ObjectInputStream(Files.newInputStream(source))) {
      return (Eagle) ois.readObject();
    }
  }


}

//Bird itself is not serializable
class Bird {

  protected transient String name;
  protected int age;

  //during the serialization this constructor is called
  public Bird() {
    System.out.println("""
        no-arg constructor\s\
        of the first non-serializable parent class""");
    this.name = "Matt";
    this.age = 30;
  }

  public String getName() {
    return name;
  }

  public int getAge() {
    return age;
  }
}

class Eagle extends Bird implements Serializable {

  {
    this.name = "Olivia";
  }

  public Eagle() {
    this.name = "Bridget";
  }
}



