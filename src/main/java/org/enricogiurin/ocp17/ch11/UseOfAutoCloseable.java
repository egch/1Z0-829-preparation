package org.enricogiurin.ocp17.ch11;

import java.io.Closeable;

public class UseOfAutoCloseable {

  //TWDEF
  public static void main(String[] args) {
    var d = new Door();
    try (d; var w = new Window()) {
      System.out.print("T");
    } catch (Exception e) {
      System.out.print("E");
    } finally {
      System.out.print("F");
    }
  }

  static class Door implements AutoCloseable {

    public void close() {
      System.out.print("D");
    }
  }

  static class Window implements Closeable {

    public void close() {
      System.out.print("W");
      throw new RuntimeException();
    }
  }
}
