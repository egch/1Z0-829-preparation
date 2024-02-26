package org.enricogiurin.ocp17.book.ch15.rollback;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.enricogiurin.ocp17.book.ch15.SetupDataBase;

public class CommitAndRollback {

  public static void main(String[] args) throws SQLException {
    new CommitAndRollback().rollback_setAutoCommitTrue();
  }

  void rollbackOnAutocommit() throws SQLException {
    String SQL_UPDATE = """
        update games set description = 'Boring' where name = 'Monopoly'""";
    try (Connection conn = DriverManager.getConnection(SetupDataBase.JDBC_URL);
        PreparedStatement preparedStatement = conn.prepareStatement(SQL_UPDATE)) {
      int update = preparedStatement.executeUpdate();
      System.out.println(update);
      boolean isAutocommit = conn.getAutoCommit();
      System.out.println("autocommit: " + isAutocommit);
      //this call has no effect
      conn.rollback();
    }

  }

  void addAndSubtract() throws SQLException {
    try (Connection connection = DriverManager.getConnection(SetupDataBase.JDBC_URL)) {
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

  void rollback_setAutoCommitTrue() throws SQLException {
    String sql = "INSERT INTO games(id, name) VALUES(10, 'Jenga');";
    try (Connection connection = DriverManager.getConnection(SetupDataBase.JDBC_URL)) {
      connection.setAutoCommit(true);
      try (PreparedStatement ps = connection.prepareStatement(sql,
          ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY)) {
        ps.executeUpdate();
      }
      //calling rollback when auto commit set to true has no effect
      //but no exception is thrown
      connection.rollback();
    }
  }

}
