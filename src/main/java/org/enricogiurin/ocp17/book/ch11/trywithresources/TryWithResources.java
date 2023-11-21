package org.enricogiurin.ocp17.book.ch11.trywithresources;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class TryWithResources {

  static final String PATH = "/files/sentences.txt";

  public static void main(String[] args) {
    new TryWithResources().statement();
  }

  void readFile() {
    try (InputStream inputStream = getClass().getResourceAsStream(PATH);
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {
      String line;
      while ((line = reader.readLine()) != null) {
        System.out.println(line);
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  //output:
//    try
//    1
//    closing: 2
//    closing: 1
//    catch
//    finally
  void statement() {
    try (MyFileClass mf1 = new MyFileClass(1);
        MyFileClass mf2 = new MyFileClass(2)) {

      System.out.println("try");
      System.out.println(mf1.num);
      throw new RuntimeException();

    } catch (Exception e) {
      //mf1 is not in scope, only in the try block
      // System.out.println(mf1.num);
      System.out.println("catch");
    } finally {
      System.out.println("finally");
    }
  }

  void effectiveFinal() {
    //alternative way, but mf1 needs to be final or effective final
    var mf1 = new MyFileClass(1);
    try (mf1) {

    } catch (Exception e) {

    }

  }

  void notEffectiveFinal() {
    //alternative way, but mf1 needs to be final or effective final
    var mf1 = new MyFileClass(1);
    //Variable used as a try-with-resources resource should be final or effectively final
    try (mf1) {
      //with this uncommented won't compile
      // mf1=null;

    } catch (Exception e) {

    }

  }

  private static record MyFileClass(int num) implements AutoCloseable {

    @Override
    public void close() throws Exception {
      System.out.println("closing: " + num);
    }
  }


}






