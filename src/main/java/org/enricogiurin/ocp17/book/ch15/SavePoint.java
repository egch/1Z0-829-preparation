package org.enricogiurin.ocp17.book.ch15;

import static org.enricogiurin.ocp17.book.ch15.SetupDataBase.JDBC_URL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Savepoint;

public class SavePoint {

  public static void main(String[] args) throws SQLException {
    SavePoint instance = new SavePoint();
    instance.countRecords();
    instance.nestedSavePoint();
    instance.countRecords();
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
      //only this record is added
      Savepoint sp = conn.setSavepoint();
      ps.setInt(1, 2);
      ps.setString(2, "Kara");
      ps.executeUpdate();
      conn.rollback(sp);  //we roll back till savePoint
      conn.commit();
    }
  }

  void nestedSavePoint() throws SQLException {
    var sql = "INSERT INTO people VALUES(?, ?, ?)";

    try (Connection conn = DriverManager.getConnection(JDBC_URL);
        var ps = conn.prepareStatement(sql,
            ResultSet.TYPE_SCROLL_SENSITIVE,
            ResultSet.CONCUR_UPDATABLE)) {

      conn.setAutoCommit(false);

      Savepoint sp1 = conn.setSavepoint();
      ps.setInt(1, 1);
      ps.setString(2, "Joslyn");
      ps.setString(3, "NY");
      ps.executeUpdate();
      //only this record is added
      Savepoint sp2 = conn.setSavepoint();
      ps.setInt(1, 2);
      ps.setString(2, "Kara");
      ps.executeUpdate();
      conn.rollback(sp2);

      conn.rollback(sp1);  //order matters
    }
  }

  void countRecords() throws SQLException {
    var sql = "select count(*) from people";
    try (Connection connection = DriverManager.getConnection(JDBC_URL);
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        ResultSet resultSet = preparedStatement.executeQuery()) {
      if (resultSet.next()) {
        int cnt = resultSet.getInt(1);
        System.out.println("there are " + cnt + " records in table people");
      }
    }
  }
}