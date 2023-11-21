package org.enricogiurin.ocp17.book.ch15;

import static org.enricogiurin.ocp17.book.ch15.SetupDataBase.JDBC_URL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Types;

public class CustomProcedure {

  public static void main(String[] args) throws SQLException {
    new CustomProcedure().two_in_out_parameter_index();
  }

  void two_in_out() throws SQLException {
    var sql = "{ ?=call two_in_out(?, ?, ?) }";
    try (Connection conn = DriverManager.getConnection(JDBC_URL);
        var cs = conn.prepareCall(sql)) {
      cs.registerOutParameter("num", Types.INTEGER);
      cs.setString("p1", "a");
      cs.setInt("p2", 2);
      cs.execute();
      //num is defined in the body of the procedure. Check SetupDataBase
      System.out.println(cs.getInt("num"));
    }
  }

  void two_in_out_parameter_index() throws SQLException {
    //mind the space between = and call
    var sql = "{  ?= call two_in_out(?, ?, ?) }";
    var sql_eq = "{ call two_in_out(?, ?, ?) }";

    //sql and sql_eq are both correct
    try (Connection conn = DriverManager.getConnection(JDBC_URL);
        var cs = conn.prepareCall(sql_eq)) {
      cs.registerOutParameter(1, Types.INTEGER);
      cs.setString(2, "15");
      cs.setInt(3, 2);
      cs.execute();
      //num is defined in the body of the procedure. Check SetupDataBase
      System.out.println(cs.getInt("num"));
    }
  }


}
