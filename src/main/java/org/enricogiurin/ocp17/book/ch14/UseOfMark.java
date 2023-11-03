package org.enricogiurin.ocp17.book.ch14;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.io.StringReader;

public class UseOfMark {

  public static void main(String[] args) throws IOException {
    new UseOfMark().markSkip();
  }

  void mark() throws IOException {
    final String name = "enrico";
    try (InputStream inputStream = new ByteArrayInputStream(name.getBytes())) {
      if (inputStream.markSupported()) {
        inputStream.mark(1);
        System.out.print((char) inputStream.read());
        System.out.print((char) inputStream.read());
        inputStream.reset();
        System.out.println();
      }
      System.out.print((char) inputStream.read());
      System.out.print((char) inputStream.read());
      //en
      //en
    }
  }

  void markLimit() throws IOException {
    final String name = "ciao";
    try (InputStream inputStream = new ByteArrayInputStream(name.getBytes())) {
      if (inputStream.markSupported()) {
        inputStream.mark(1);
        System.out.print((char) inputStream.read());
        System.out.print((char) inputStream.read());
        System.out.print((char) inputStream.read());
        System.out.print((char) inputStream.read());
        System.out.print((char) inputStream.read());
        System.out.print((char) inputStream.read());
        System.out.print((char) inputStream.read());
        System.out.print((char) inputStream.read());
        System.out.print((char) inputStream.read());
        System.out.print((char) inputStream.read());
        inputStream.reset();
        System.out.println();
      }
      System.out.print((char) inputStream.read());
      System.out.print((char) inputStream.read());
      //ciao￿￿￿￿￿￿
      //ci
    }
  }

  void markSkip() throws IOException {
    var sb = new StringBuilder();
    try (Reader reader = new StringReader("PEACOCKS")) {
      sb.append((char) reader.read());  //P added
      System.out.println("markSupported: " + reader.markSupported());

      //since we are using StringReader the parameter passed
      //(as long as greater than zero) has no effect
      reader.mark(1);
      for (int i = 0; i < 2; i++) {
        sb.append((char) reader.read());
        long skip = reader.skip(2);
        //  (0) E added | AC skipped
        //  (1) O added | CK skipped
        System.out.println("skip: " + skip);
      }
      //reset to E
      reader.reset();
      reader.skip(0);
      //E added
      sb.append((char) reader.read());
    }
    //PEOE
    System.out.println(sb);
  }

}
