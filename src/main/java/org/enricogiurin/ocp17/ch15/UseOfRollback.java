package org.enricogiurin.ocp17.ch15;

import static org.enricogiurin.ocp17.ch15.SetupDataBase.JDBC_URL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Savepoint;

public class UseOfRollback {

  public static void main(String[] args) throws SQLException {
    new UseOfRollback().savePoint();
  }

  void savePoint() throws SQLException {
    var sql = "INSERT INTO people VALUES(?, ?, ?)";

    try (Connection conn = DriverManager.getConnection(JDBC_URL);
        var ps = conn.prepareStatement(sql,
            ResultSet.TYPE_SCROLL_SENSITIVE,
            ResultSet.CONCUR_UPDATABLE)) {
      conn.setAutoCommit(false);

      ps.setInt(1, 1);
      ps.setString(2, "Joslyn");
      ps.setString(3, "NY");
      ps.executeUpdate();
      Savepoint sp = conn.setSavepoint();
      ps.setInt(1, 2);
      ps.setString(2, "Kara");
      ps.executeUpdate();
      conn.rollback(sp);
    }

  }
}