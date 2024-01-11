package org.enricogiurin.ocp17.book.ch11.exceptions;

import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLException;

public class MultiCatchBlock {

  public static void main(String[] args) {
    new MultiCatchBlock().parse();
  }

  void parse() {
    String[] array = {"a"};
    try {
      Integer.parseInt(array[1]);
    } catch (ArrayIndexOutOfBoundsException | NumberFormatException e) {
      e.printStackTrace();
    }
  }

  void wrongMultiCatch() {
    try {
      FileReader fileReader = new FileReader("/tmp/a");

      fileReader.close();
      //Types in multi-catch must be disjoint: 'java.io.FileNotFoundException' is a subclass of 'java.io.IOException'
      /*} catch (IOException | FileNotFoundException e) { */
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  //I need to declare both the CE
  void rethrowMultiCatch() throws SQLException, IOException {
    try {
      if(1>3){
        throw new SQLException();
      }else{
        throw new IOException();
      }
      //I do not need to have throws for the RTE!
    }catch (RuntimeException | SQLException | IOException e){
      //If I rethrow a checked exception from multi catch then
      //I need to declare both in the throws clause
      throw e;
    }
  }

}
