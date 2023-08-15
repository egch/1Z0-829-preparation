package org.enricogiurin.ocp17.ch15;

import static org.enricogiurin.ocp17.ch15.SetupDataBase.URL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Types;

public class StoredProcedure {

  public static void main(String[] args) throws SQLException {
    new StoredProcedure().outParameter();
  }

  void outParameter() throws SQLException {
    var sql = "{?= call magic_number(?) }";
    try (Connection conn = DriverManager.getConnection(URL);
        var cs = conn.prepareCall(sql)) {
      cs.registerOutParameter(1, Types.INTEGER);
      cs.execute();

      //num is defined in the body of the procedure. Check SetupDataBase
      System.out.println(cs.getInt("num"));
    }
  }


}
