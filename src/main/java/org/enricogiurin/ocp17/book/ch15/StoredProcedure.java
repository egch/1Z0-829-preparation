package org.enricogiurin.ocp17.book.ch15;

import static org.enricogiurin.ocp17.book.ch15.SetupDataBase.JDBC_URL;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

/**
 * All the related stored procedures are defined here:
 *
 * @see SetupDataBase
 */

public class StoredProcedure {

  public static void main(String[] args) throws SQLException {
    new StoredProcedure().double_number();
  }

  /**
   * Neither IN nor OUT parameters
   * @throws SQLException
   */
  void read_e_names() throws SQLException {
    var sql = "{call read_e_names()}";
    try (Connection connection = DriverManager.getConnection(JDBC_URL);
        CallableStatement callableStatement = connection.prepareCall(sql);
        ResultSet resultSet = callableStatement.executeQuery()
    ) {
      while (resultSet.next()) {
        System.out.println(resultSet.getString("name"));
        //Elsa
        //Ester
        //Eddie
      }
    }
  }

  /**
   * Passing IN parameter
   * @throws SQLException
   */
  void read_names_by_letter() throws SQLException {
    var sql = "{call read_names_by_letter(?) }";
    try (Connection connection = DriverManager.getConnection(JDBC_URL);
        CallableStatement callableStatement = connection.prepareCall(sql)) {
      callableStatement.setString("prefix", "z");
      try (ResultSet resultSet = callableStatement.executeQuery()) {
        while (resultSet.next()) {
          System.out.println(resultSet.getString("name"));
          //Zelda
          //Zoe
        }
      }
    }
  }

  /**
   * Returning OUT parameters
   * @throws SQLException
   */
  void magic_number() throws SQLException {
    //Mind the ?=
    var sql = "{ ?= call magic_number(?) }";
    try (Connection conn = DriverManager.getConnection(JDBC_URL);
        var cs = conn.prepareCall(sql)) {
      //NOTE: we register the out parameter
      cs.registerOutParameter(1, Types.INTEGER);
      cs.execute();
      //NOTE: Here I do not use the ResultSet!
      //num is defined in the body of the procedure.
      System.out.println(cs.getInt("num"));
    }
  }

  /**
   * INOUT parameter
   * @throws SQLException
   */
  void double_number() throws SQLException {
    var sql = "{call double_number(?) }";  //CREATE PROCEDURE double_number(INOUT num INT) READS SQL DATA
    try (Connection connection = DriverManager.getConnection(JDBC_URL);
        CallableStatement cs = connection.prepareCall(sql)) {
      //remember: CREATE PROCEDURE double_number(INOUT num INT) READS SQL DATA
      //so num is both IN parameter and OUT parameter
      cs.setInt("num", 23);
      cs.registerOutParameter("num", Types.INTEGER);
      //equivalent: cs.registerOutParameter(1, Types.INTEGER);
      cs.execute();
      //I do not need to use isResultSet
      System.out.println(cs.getInt("num"));
    }
  }

}
