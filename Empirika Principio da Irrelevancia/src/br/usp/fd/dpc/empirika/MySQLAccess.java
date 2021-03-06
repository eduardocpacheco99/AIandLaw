package br.usp.fd.dpc.empirika;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import br.usp.fd.dpc.empirika.fluxo.lerAcordao.documento;

public class MySQLAccess {
  private Connection connect = null;
  private Statement statement = null;
  private PreparedStatement preparedStatement = null;
  private ResultSet resultSet = null;

  public List<documento>  readDataBase() throws Exception {
    try {   	// This will load the MySQL driver, each DB has its own driver
      Class.forName("com.mysql.jdbc.Driver");
      // Setup the connection with the DB
      connect = DriverManager
          .getConnection("jdbc:mysql://localhost/empirika?"
              + "user=root&password=All4din2014");

      // Statements allow to issue SQL queries to the database
      statement = connect.createStatement();
      // Result set get the result of the SQL query
      resultSet = statement
          .executeQuery("select * from empirika.documento;");
   return getEmailList(resultSet);
/*
      // PreparedStatements can use variables and are more efficient
      preparedStatement = connect
          .prepareStatement("insert into  feedback.comments values (default, ?, ?, ?, ? , ?, ?)");
      // "myuser, webpage, datum, summery, COMMENTS from feedback.comments");
      // Parameters start with 1
      preparedStatement.setString(1, "Test");
      preparedStatement.setString(2, "TestEmail");
      preparedStatement.setString(3, "TestWebpage");
      preparedStatement.setDate(4, new java.sql.Date(2009, 12, 11));
      preparedStatement.setString(5, "TestSummary");
      preparedStatement.setString(6, "TestComment");
      preparedStatement.executeUpdate();

      preparedStatement = connect
          .prepareStatement("SELECT myuser, webpage, datum, summery, COMMENTS from feedback.comments");
      resultSet = preparedStatement.executeQuery();
      writeResultSet(resultSet);

      // Remove again the insert comment
      preparedStatement = connect
      .prepareStatement("delete from feedback.comments where myuser= ? ; ");
      preparedStatement.setString(1, "Test");
      preparedStatement.executeUpdate();
      
      resultSet = statement
      .executeQuery("select * from feedback.comments");
      writeMetaData(resultSet);
*/      
    } catch (Exception e) {
      throw e;
    } finally {
      close();
    }

  }

  public void  writeDataBase(documento email) throws Exception {
	    try {   	// This will load the MySQL driver, each DB has its own driver
	      Class.forName("com.mysql.jdbc.Driver");
	      // Setup the connection with the DB
	      connect = DriverManager
	          .getConnection("jdbc:mysql://localhost/empirika?"
	              + "user=root&password=All4din2014");

	      // Statements allow to issue SQL queries to the database
	      statement = connect.createStatement();
	      // Result set get the result of the SQL query
//	      resultSet = statement
	      // PreparedStatements can use variables and are more efficient
	      preparedStatement = connect
	          .prepareStatement("insert into  empirika.documento values (  ?,   ?,?,null)");
	      // "myuser, webpage, datum, summery, COMMENTS from feedback.comments");
	      // Parameters start with 1
	      preparedStatement.setInt(1, 0);
	      preparedStatement.setString(3, email.getSubject());
	      preparedStatement.setString(2, email.getFile());
	      preparedStatement.executeUpdate();
	    } catch (Exception e) {
	      throw e;
	    } finally {
	      close();
	    }

	  }

  
  private void writeMetaData(ResultSet resultSet) throws SQLException {
    //   Now get some metadata from the database
    // Result set get the result of the SQL query
    
    System.out.println("The columns in the table are: ");
    
    System.out.println("Table: " + resultSet.getMetaData().getTableName(1));
    for  (int i = 1; i<= resultSet.getMetaData().getColumnCount(); i++){
      System.out.println("Column " +i  + " "+ resultSet.getMetaData().getColumnName(i));
    }
  }

  private List<documento> getEmailList(ResultSet resultSet) throws SQLException {
	  List ll = new LinkedList<documento>();
	  // ResultSet is initially before the first data set
    while (resultSet.next()) {
    	documento email = new documento();
      // It is possible to get the columns via name
      // also possible to get the columns via the column number
      // which starts at 1
      // e.g. resultSet.getSTring(2);
      int id = resultSet.getInt("id");
      String subject = resultSet.getString("conteudo");
      Long data = resultSet.getLong("tempo");
      String file = resultSet.getString("documento");
      email.setId(0);
      email.setSubject(subject);
      email.setDate(data);
      email.setFile(file);
      
      ll.add(email);
      
      //String website = resultSet.getString("webpage");
      //String summery = resultSet.getString("summery");
      //Date date = resultSet.getDate("datum");
     // String comment = resultSet.getString("comments");
     // System.out.println("id: " + email.getId());
    //  System.out.println("id: " + email.getFile());
      
      // System.out.println("Website: " + website);
      //System.out.println("Summery: " + summery);
      //System.out.println("Date: " + date);
      //System.out.println("Comment: " + comment);
    }
    return ll;
  }

  // You need to close the resultSet
  private void close() {
    try {
      if (resultSet != null) {
        resultSet.close();
      }

      if (statement != null) {
        statement.close();
      }

      if (connect != null) {
        connect.close();
      }
    } catch (Exception e) {

    }
  }

}


