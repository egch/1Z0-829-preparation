package org.enricogiurin.ocp17.book.ch14;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serial;
import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.Path;

public class SerializationOfRecord {

  public static void main(String[] args) throws IOException, ClassNotFoundException {
    SerializationOfRecord instance = new SerializationOfRecord();
    instance.serializePerson();
    instance.deSerializePerson();

  }

  void serializePerson() throws IOException {
    Person enrico = new Person("Enrico", "Giurin");
    Person balint = new Person("Balint", "Domokos");
    Path dest = Path.of("/tmp/people.ser");

    try (ObjectOutputStream oos = new ObjectOutputStream(
        new BufferedOutputStream(
            Files.newOutputStream(dest)))) {
      oos.writeObject(enrico);
      oos.writeObject(balint);
    }
  }

  void deSerializePerson() throws IOException, ClassNotFoundException {

    //Person[firstName=Enrico, lastName=Giurin]
    //Person[firstName=Balint, lastName=Domokos]
    Path dest = Path.of("/tmp/people.ser");
    try (ObjectInputStream ois = new ObjectInputStream(
        new BufferedInputStream(
            Files.newInputStream(dest)))) {
      while (true) {
        var obj = ois.readObject();
        if (obj instanceof Person p) {
          System.out.println(p);
        }
      }
    } catch (EOFException e) {
    }
  }

  record Person(String firstName, String lastName) implements Serializable {

    @Serial
    private static final long serialVersionUID = 2L;
  }
}



