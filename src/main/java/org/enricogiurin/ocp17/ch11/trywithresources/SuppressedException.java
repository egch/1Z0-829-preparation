package org.enricogiurin.ocp17.ch11.trywithresources;

public class SuppressedException {

  public static void main(String[] args) {
    new SuppressedException().suppressed();
  }

  void suppressed() {
    try (var suppressedAutoCloseable = new SuppressedAutoCloseable()) {
      throw new RuntimeException("try failed");
    } catch (Exception e) {
      System.out.println("caught: " + e.getMessage());
      for (Throwable t : e.getSuppressed()) {
        System.out.println("suppressed: " + t.getMessage());
      }

    }
  }

  private static class SuppressedAutoCloseable implements AutoCloseable {

    @Override
    public void close() throws IllegalStateException {
      System.out.println("closing: ");
      throw new IllegalStateException("failing to close resources");
    }
  }
}


