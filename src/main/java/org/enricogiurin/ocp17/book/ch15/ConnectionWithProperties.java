package org.enricogiurin.ocp17.book.ch15;

import static org.enricogiurin.ocp17.book.ch15.SetupDataBase.JDBC_URL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionWithProperties {

  public static void main(String[] args) throws SQLException {
    new ConnectionWithProperties().properties();
  }

  void properties() throws SQLException {
    Properties properties = new Properties();
    //currently hsqldb does not require username/pwd
    //properties.setProperty("user", "");
    //properties.setProperty("password", "");
    Connection connection = DriverManager.getConnection(JDBC_URL, properties);
    try (connection) {
      System.out.println("closing");
    }
  }

}
