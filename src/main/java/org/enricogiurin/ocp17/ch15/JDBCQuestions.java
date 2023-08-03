package org.enricogiurin.ocp17.ch15;

import static org.enricogiurin.ocp17.ch15.SetupDataBase.URL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JDBCQuestions {

  public static void main(String[] args) throws SQLException {
    new JDBCQuestions().updateHabitat();
  }

  void updateHabitat() throws SQLException {
    var sql = """
        UPDATE habitat SET environment = null WHERE environment = ? """;
    try (Connection conn = DriverManager.getConnection(URL)) {
      PreparedStatement ps = conn.prepareStatement(sql);
      ps.setString(1, "world");
      int row = ps.executeUpdate();
      System.out.println("updated: " + row);
    }
  }


}
