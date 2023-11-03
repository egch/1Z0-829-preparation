package org.enricogiurin.ocp17.book.ch15;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LogSQLException {

  public static void main(String[] args) {
    new LogSQLException().log();
  }

  void log() {
    try (Connection connection = DriverManager.getConnection(SetupDataBase.JDBC_URL);
        PreparedStatement preparedStatement = connection.prepareStatement(
            "select name from not_existing");
        ResultSet resultSet = preparedStatement.executeQuery()) {
      while (resultSet.next()) {
        System.out.println(resultSet.getString("not-a-column"));
      }
    } catch (SQLException e) {
      System.out.println("message: " + e.getMessage());
      System.out.println("state: " + e.getSQLState());
      System.out.println("error code: " + e.getErrorCode());
      //message: user lacks privilege or object not found: NOT_EXISTING in statement [select name from not_existing]
      //state: 42501
      //error code: -5501
    }
  }
}


