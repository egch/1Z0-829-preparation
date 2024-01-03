package org.enricogiurin.ocp17.book.ch15;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UsageOfStatement {

  public static void main(String[] args) throws SQLException {
    new UsageOfStatement().statementException();
  }


  void delete() throws SQLException {
    Connection connection = null;
    String sql = null;
//get a Statement
    Statement statement = connection.createStatement();

//get a PreparedStatement
    PreparedStatement ps = connection.prepareStatement(sql);

//get a CallableStatement (store procedure)
    CallableStatement callableStatement = connection.prepareCall(sql);
  }
  void statement() throws SQLException {
    String updateSQL = """
        update games set description = 'sad game' where name='Monopoly'""";
    try(Connection conn = DriverManager.getConnection(SetupDataBase.JDBC_URL);
        Statement statement = conn.createStatement()){
      //there is no set parameter in the statement
      //statement.setInt()
      boolean isResultSet = statement.execute(updateSQL);
      if (isResultSet) {
        ResultSet resultSet = statement.getResultSet();
        //get the result
      } else {
        int updateCount = statement.getUpdateCount();
        System.out.println(updateCount);
      }

    }
  }

  void statementException() throws SQLException {
    String updateSQL = """
        update games set description = 'sad game' where name=? """;
    try(Connection conn = DriverManager.getConnection(SetupDataBase.JDBC_URL);
        Statement statement = conn.createStatement()){
      //there is no set parameter in the statement
      //statement.setInt()
      //Exception in thread "main" java.sql.SQLSyntaxErrorException: parameter marker not allowed
      boolean isResultSet = statement.execute(updateSQL);
      System.out.println(isResultSet);
      int updateCount = statement.getUpdateCount();
      System.out.println(updateCount);
    }
  }

}
