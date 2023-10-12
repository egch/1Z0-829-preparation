package org.enricogiurin.ocp17.ch15;

import static org.enricogiurin.ocp17.ch15.SetupDataBase.JDBC_URL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CommitAndRollback {

  public static void main(String[] args) throws SQLException {
    new CommitAndRollback().addAndSubtract();
  }

  void addAndSubtract() throws SQLException {
    try (Connection connection = DriverManager.getConnection(JDBC_URL)) {
      connection.setAutoCommit(false);
      final String update = """
          update exhibits
          set num_acres = num_acres + ?
          where name = ?""";
      int africanElephant = modifyAcres(connection, update, -5, "African Elephant");
      int zebra = modifyAcres(connection, update, 5, "Zebra");
      if (africanElephant == 0 || zebra == 0) {
        connection.rollback();
        System.out.println("connection rollback!");
        return;
      }
      final String select = """
          select count(*)
          from exhibits
          where num_acres <=0""";
      try (PreparedStatement preparedStatement = connection.prepareStatement(select);
          ResultSet resultSet = preparedStatement.executeQuery()) {
        if (resultSet.next()) {
          int count = resultSet.getInt(1);
          if (count == 0) {
            connection.commit();
          } else {
            connection.rollback();
            System.out.println("connection rollback!");
          }
        }
      }//end of try with resources
    }
  }

  private int modifyAcres(Connection connection, final String sql, int deltaAcres, String name)
      throws SQLException {
    try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
      preparedStatement.setInt(1, deltaAcres);
      preparedStatement.setString(2, name);
      int updated = preparedStatement.executeUpdate();
      System.out.println("updated " + updated + " records");
      return updated;
    }
  }

}
