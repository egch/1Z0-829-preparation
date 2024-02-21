package org.enricogiurin.ocp17.book.ch11.exceptions;

public class ThrowInCatch {

  public static void main(String[] args) {
    new ThrowInCatch().handleCatch();
  }

  //it prints WXZ followed by the stacktrace

  void handleCatch() {
    try {
      System.out.print('W');
      throw new ArrayIndexOutOfBoundsException();
    } catch (RuntimeException r) {
      System.out.print('X');
      //this is not caught in the next catch(Exception e) block
      throw r;
    } catch (Exception e) {
      System.out.print('Y');
    } finally {
      System.out.print('Z');
    }
  }

}
