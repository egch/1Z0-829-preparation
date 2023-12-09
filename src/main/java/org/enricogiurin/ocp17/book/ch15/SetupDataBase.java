package org.enricogiurin.ocp17.book.ch15;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


/**
 * //copied from here:
 * https://www.selikoff.net/2022/01/22/ocp-17-book-bonus-creating-a-hsql-database-in-java-17/
 * Run this main to clean up db before any other execution
 */
public class SetupDataBase {

  static final String JDBC_URL = "jdbc:hsqldb:file:zoo";

  public static void main(String[] args) throws SQLException {
    try (Connection conn = DriverManager.getConnection(JDBC_URL)) {

      dropExisting(conn);
      createTables(conn);
      createStoredProcedures(conn);

      printCount(conn, "SELECT count(*) FROM names");
    }
  }

  private static void dropExisting(Connection conn) throws SQLException {
    run(conn, "DROP PROCEDURE read_e_names IF EXISTS");
    run(conn, "DROP PROCEDURE read_names_by_letter IF EXISTS");
    run(conn, "DROP PROCEDURE magic_number IF EXISTS");
    run(conn, "DROP PROCEDURE double_number IF EXISTS");
    run(conn, "DROP PROCEDURE two_in_out IF EXISTS");
    run(conn, "DROP TABLE names IF EXISTS");
    run(conn, "DROP TABLE exhibits IF EXISTS");
    run(conn, "DROP TABLE habitat IF EXISTS");
    run(conn, "DROP TABLE games IF EXISTS");
    run(conn, "DROP TABLE counts IF EXISTS");
    run(conn, "DROP TABLE people IF EXISTS");
  }

  private static void createTables(Connection conn) throws SQLException {
    run(conn, """
        CREATE TABLE exhibits (
          id INTEGER PRIMARY KEY,
          name VARCHAR(255),
          num_acres DECIMAL(4,1))""");

    run(conn, """
        CREATE TABLE names (
           id INTEGER PRIMARY KEY,
           species_id integer REFERENCES exhibits (id),
           name VARCHAR(255))""");

    run(conn, """
        CREATE TABLE habitat (
          id INTEGER PRIMARY KEY,
          environment VARCHAR(255))""");

    run(conn, """
        CREATE TABLE games (
          id INTEGER PRIMARY KEY,
          name VARCHAR(255) NOT NULL,
          description VARCHAR(255))""");

    run(conn, """
        CREATE TABLE counts (
        id INTEGER PRIMARY KEY,
        num INTEGER)""");

    run(conn, """
        CREATE TABLE people (
        id INTEGER PRIMARY KEY,
        name VARCHAR(255),
        state VARCHAR(255))""");

    run(conn, "INSERT INTO exhibits VALUES (1, 'African Elephant', 7.5)");
    run(conn, "INSERT INTO exhibits VALUES (2, 'Zebra', 1.2)");

    run(conn, "INSERT INTO names VALUES (1, 1, 'Elsa')");
    run(conn, "INSERT INTO names VALUES (2, 2, 'Zelda')");
    run(conn, "INSERT INTO names VALUES (3, 1, 'Ester')");
    run(conn, "INSERT INTO names VALUES (4, 1, 'Eddie')");
    run(conn, "INSERT INTO names VALUES (5, 2, 'Zoe')");

    run(conn, "INSERT INTO habitat(id, environment) VALUES (1, 'world')");

    run(conn, "INSERT INTO counts(id, num) VALUES (1, 4)");
    run(conn, "INSERT INTO counts(id, num) VALUES (2, 5)");

    run(conn, "INSERT INTO games(id, name, description) VALUES (1, 'Monopoly', 'Property trading board game')");
  }

  private static void createStoredProcedures(Connection conn) throws SQLException {
    String noParams = """
        CREATE PROCEDURE read_e_names()
        READS SQL DATA DYNAMIC RESULT SETS 1
        BEGIN ATOMIC
        DECLARE result CURSOR WITH RETURN FOR SELECT * FROM names WHERE LOWER(name) LIKE 'e%';
        OPEN result;
        END""";

    String inParam = """
        CREATE PROCEDURE read_names_by_letter(IN prefix VARCHAR(10))
        READS SQL DATA DYNAMIC RESULT SETS 1
        BEGIN ATOMIC
        DECLARE result CURSOR WITH RETURN FOR
        SELECT * FROM names WHERE LOWER(name) LIKE CONCAT(LOWER(prefix), '%');
        OPEN result;
        END""";

    String inOutParam = """
        CREATE PROCEDURE double_number(INOUT num INT) READS SQL DATA
          DYNAMIC RESULT SETS 1
          BEGIN ATOMIC 
          SET num = num * 2; 
          END""";

    String outParam = """
        CREATE PROCEDURE magic_number(OUT num INT) READS SQL DATA
              BEGIN ATOMIC
             SET num = 42;
              END""";

    String twoInOutParam = """
        CREATE PROCEDURE two_in_out(OUT num INT, IN p1 VARCHAR(10), IN p2 INT) READS SQL DATA
              BEGIN ATOMIC
              DECLARE p1_as_int INT;
              SET p1_as_int = CAST(p1 as INT);
              SET num = p1_as_int + p2;
              END""";

    run(conn, noParams);
    run(conn, inParam);
    run(conn, outParam);
    run(conn, inOutParam);
    run(conn, twoInOutParam);
  }

  private static void run(Connection conn, String sql) throws SQLException {
    try (PreparedStatement ps = conn.prepareStatement(sql)) {
      int updated = ps.executeUpdate();
      System.out.println("updated " + updated + " records");
    }
  }

  private static void printCount(Connection conn, String sql) throws SQLException {
    try (PreparedStatement ps = conn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery()) {
      rs.next();
      System.out.println(rs.getInt(1));
    }
  }
}

