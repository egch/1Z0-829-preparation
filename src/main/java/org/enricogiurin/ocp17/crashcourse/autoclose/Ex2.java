package org.enricogiurin.ocp17.crashcourse.autoclose;

import java.sql.SQLException;

class AC4 implements AutoCloseable {

  @Override
  public void close() throws Exception {
    throw new SQLException();
  }
}

class Q7 {

  public static void main(String[] args) {
    try {
      doIt();
    } catch (Throwable t) {
      t.printStackTrace();
    }
  }

  public static void doIt() throws Throwable {
    try (
        var one = new AC4();
        var two = new AC4();
    ) {
//      throw new FileNotFoundException();
    }
  }
}

