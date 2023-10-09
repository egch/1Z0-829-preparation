package org.enricogiurin.ocp17.ch15;

import static org.enricogiurin.ocp17.ch15.SetupDataBase.JDBC_URL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JDBCQuestions {


  public static void main(String[] args) throws SQLException {
    new JDBCQuestions().switchAutoCommitFromFalseToTrue();
  }

  void updateHabitat() throws SQLException {
    var sql = """
        UPDATE habitat SET environment = null WHERE environment = ? """;
    try (Connection conn = DriverManager.getConnection(JDBC_URL)) {
      PreparedStatement ps = conn.prepareStatement(sql);
      ps.setString(1, "world");
      int row = ps.executeUpdate();
      System.out.println("updated: " + row);
    }
  }

  void rollback() throws SQLException {
    String sql = "INSERT INTO games VALUES(3, 'Jenga');";
    try (Connection conn = DriverManager.getConnection(JDBC_URL);
        PreparedStatement ps = conn.prepareStatement(sql, ResultSet.TYPE_FORWARD_ONLY,
            ResultSet.CONCUR_READ_ONLY)
    ) {
      conn.setAutoCommit(true);
      ps.executeUpdate();
      conn.rollback();
    }
  }

  void psExecutedTwice() throws SQLException {
    var sql = "SELECT num FROM counts WHERE num> ?";
    try (Connection conn = DriverManager.getConnection(JDBC_URL);
        var ps = conn.prepareStatement(sql)) {
      ps.setInt(1, 3);
      try (var rs = ps.executeQuery()) {
        while (rs.next()) {
          System.out.println(rs.getObject(1));
        }
      }
      try (var rs = ps.executeQuery()) {
        while (rs.next()) {
          System.out.println(rs.getObject(1));
        }
      }
    }
  }

  void switchAutoCommitFromFalseToTrue() throws SQLException {

    try (Connection conn = DriverManager.getConnection(JDBC_URL)) {
      conn.setAutoCommit(false);
      String sql = "INSERT INTO exhibits VALUES(3, 'Test', 2)";
      try (PreparedStatement ps = conn.prepareStatement(sql)) {
        ps.executeUpdate();
      }
      //The code starts with autocommit off. Then we turn autocommit mode back on a
      // nd immediately commit the transaction.
      conn.setAutoCommit(true);
    }
  }
}
