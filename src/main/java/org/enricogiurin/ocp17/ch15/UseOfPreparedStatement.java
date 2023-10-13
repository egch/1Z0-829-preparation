package org.enricogiurin.ocp17.ch15;

import static org.enricogiurin.ocp17.ch15.SetupDataBase.JDBC_URL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class UseOfPreparedStatement {

  public static void main(String[] args) throws SQLException {
    UseOfPreparedStatement instance = new UseOfPreparedStatement();
    instance.insert();
    instance.update_execute();
    instance.selectWithBind();
    instance.delete();
  }

  void insert() throws SQLException {
    try (Connection connection = DriverManager.getConnection(JDBC_URL);
        PreparedStatement preparedStatement = connection.prepareStatement(
            "insert into games (id, name) values (1, ?)")) {
      printDriverInfo(connection);
      preparedStatement.setString(1, "m-football");
      int row = preparedStatement.executeUpdate();
      System.out.println("inserted: " + row);
    }
  }

  void update() throws SQLException {
    try (Connection connection = DriverManager.getConnection(JDBC_URL);
        PreparedStatement preparedStatement = connection.prepareStatement(
            "update games set description = ? where name = ?")) {
      preparedStatement.setString(1, "football five as side");
      preparedStatement.setString(2, "m-football");
      int row = preparedStatement.executeUpdate();
      System.out.println("updated: " + row);
    }
  }

  void select() throws SQLException {
    try (Connection connection = DriverManager.getConnection(JDBC_URL);
        PreparedStatement preparedStatement = connection.prepareStatement(
            "select id, name, description from games");
        ResultSet resultSet = preparedStatement.executeQuery()) {
      while (resultSet.next()) {
        System.out.println(
            "id: " + resultSet.getInt("id") +
                " - name: " + resultSet.getString("name")
                + " - description: " + resultSet.getString("description"));
      }
    }
  }

  void selectWithBind() throws SQLException {
    try (Connection connection = DriverManager.getConnection(JDBC_URL);
        PreparedStatement preparedStatement = connection.prepareStatement(
            "select id, name, description from games where id != ?")) {

      //I cannot set the ps here within the try-with-resources
      preparedStatement.setInt(1, 0);
      try (ResultSet resultSet = preparedStatement.executeQuery()) {
        while (resultSet.next()) {
          System.out.println(
              "id: " + resultSet.getInt("id") +
                  " - name: " + resultSet.getString("name")
                  + " - description: " + resultSet.getString("description"));
        }
      }//inner try-with-resources
    }  //outer try-with-resources
  }


  void update_execute() throws SQLException {
    try (Connection connection = DriverManager.getConnection(JDBC_URL);
        PreparedStatement preparedStatement = connection.prepareStatement(
            "update games set description = ? where name = ?")) {
      preparedStatement.setString(1, "football five as side");
      preparedStatement.setString(2, "m-football");
      //here we use execute()
      boolean isResultSet = preparedStatement.execute();
      if (!isResultSet) {
        System.out.println("updated: " + preparedStatement.getUpdateCount());
      }else{
        //we do not use it but just to see how to retrieve it
        ResultSet resultSet = preparedStatement.getResultSet();
      }
    }
  }

  void delete() throws SQLException {
    try (Connection connection = DriverManager.getConnection(JDBC_URL);
        PreparedStatement preparedStatement = connection.prepareStatement(
            "delete from games where name=?")) {
      preparedStatement.setString(1, "m-football");
      int row = preparedStatement.executeUpdate();
      System.out.println("deleted: " + row);
    }
  }


  private void printDriverInfo(Connection connection) throws SQLException {
    System.out.println("Driver Name: " + connection.getMetaData().getDriverName());
    System.out.println("Driver Version: " + connection.getMetaData().getDriverVersion());
  }
}

