package org.enricogiurin.ocp17.book.ch15.rollback;

import static org.enricogiurin.ocp17.book.ch15.SetupDataBase.JDBC_URL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Savepoint;

//always run SetupDataBase before
public class InvalidatePreviousSavePoints {

  public static void main(String[] args) throws SQLException {
    new InvalidatePreviousSavePoints().invalidate();
  }

  void invalidate() throws SQLException {
    var sql = "INSERT INTO counts(id, num) VALUES (?, ?)";

    try (Connection conn = DriverManager.getConnection(JDBC_URL);
        var ps = conn.prepareStatement(sql,
            ResultSet.TYPE_SCROLL_SENSITIVE,
            ResultSet.CONCUR_UPDATABLE)) {

      conn.setAutoCommit(false);

      Savepoint sp1 = conn.setSavepoint();
      ps.setInt(1, 3);
      ps.setInt(2, 3);
      ps.executeUpdate();
      //only this record is added
      Savepoint sp2 = conn.setSavepoint();
      //When the rollback to sp1 happens on line 21, it invalidates all prior savepoints.
      // This causes the rollback to sp2 on conn.rollback(sp2) to throw a SQLException
      conn.rollback(sp1);
      ps.setInt(1, 4);
      ps.setInt(2, 4);
      ps.executeUpdate();
      //the following line throws an exception:
      //Exception in thread "main" java.sql.SQLException: savepoint exception: invalid specification: SYSTEM_SAVEPOINT_1
      conn.rollback(sp2);
    }
  }
}
