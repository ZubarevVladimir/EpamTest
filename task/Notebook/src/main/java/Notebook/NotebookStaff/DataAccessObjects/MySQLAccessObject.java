package Notebook.NotebookStaff.DataAccessObjects;

import Notebook.Notebook.Notebook;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Properties;
import java.util.Set;

public class MySQLAccessObject implements IDataAccessObject {

  private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/notebook_db?autoReconnect=true&useSSL=false&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
  private static final String USERNAME = "root";
  private static final String PASSWORD = "12345";
  private Connection connection;
  private Properties properties;

  public MySQLAccessObject() {
    connection = connect();
  }

  private Properties getProperties() {
    if (properties == null) {
      properties = new Properties();
      properties.setProperty("user", USERNAME);
      properties.setProperty("password", PASSWORD);
    }
    return properties;
  }

  private Connection connect() {
    if (connection == null) {
      try {
        connection = DriverManager.getConnection(DATABASE_URL, getProperties());
      } catch (SQLException e) {
        e.printStackTrace();
      }
    }
    return connection;
  }

  @Override
  public Notebook loadNotebook(int notebookID) {
    Statement st;
    ResultSet rs1;
    ResultSet rs2;
    Notebook sqlNotebook = new Notebook(0, "", "", "");
    try {
      st = connection.createStatement();
      rs1 = st.executeQuery(
          "SELECT notebook.id, notebook.title, author.author_name, author.author_surname FROM notebook, author WHERE notebook.author_id=author.id AND  notebook.id="
              + notebookID);
      while (rs1.next()) {
        sqlNotebook = new Notebook(rs1.getInt(1), rs1.getString(2),
            rs1.getString(3), rs1.getString(4));
      }
      rs2 = st.executeQuery(
          "SELECT  note.id, note.title, note.content, author.author_name,author.author_surname FROM note, author\n"
              + "WHERE notebook_id IN (" + notebookID + ") AND note.author_id=author.id");
      while (rs2.next()) {
        sqlNotebook.addNote(rs2.getInt(1), rs2.getString(2), rs2.getString(3), rs2.getString(4),
            rs2.getString(5));
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return sqlNotebook;
  }


  @Override
  public List<Notebook> loadNotebooks() {
    List<Notebook> sqlNotebooksList = new ArrayList<>();
    Statement st;
    ResultSet rs1;
    try {
      st = connection.createStatement();
      rs1 = st.executeQuery("SELECT id FROM notebook");
      while (rs1.next()) {
        sqlNotebooksList.add(loadNotebook(rs1.getInt(1)));
      }
    } catch (SQLException ex) {
      ex.getMessage();
    }
    return sqlNotebooksList;
  }

  @Override
  public void addNotebook(Notebook notebook) {
    Statement st;
    try {
      st = connection.createStatement();
      ResultSet rs;
      st.executeUpdate(
          "INSERT INTO `notebook_db`.`author` (`author_name`, `author_surname`) VALUES ('"
              + notebook.getAuthor().getName() + "', '" + notebook.getAuthor().getSurname()
              + "');");
      rs = st.executeQuery(
          "select id from author where author.author_name='" + notebook.getAuthor().getName()
              + "' and author.author_surname='" + notebook.getAuthor().getSurname() + "';");
      if (rs.next()) {
        st.executeUpdate(
            "INSERT INTO `notebook_db`.`notebook` (`author_id`, `title`) VALUES (" + rs.getInt(1)
                + ", '" + notebook.getTitle() + "');");
      }
    } catch (SQLException ex) {
      ex.printStackTrace();
    }
  }

  @Override
  public void saveNotebooks(List<Notebook> notebooksList) {

  }

  @Override
  public void deleteNotebook(int notebookID) {
    Statement st;
    try {
      ResultSet rs;
      Set<Integer> idSet = new HashSet<>();
      st = connection.createStatement();
      rs = st.executeQuery("select author_id FROM note where note.notebook_id="+notebookID);
      while (rs.next()){
        idSet.add(rs.getInt(1));
      }
      st.executeUpdate("DELETE FROM note where note.notebook_id=" + notebookID);
      rs = st.executeQuery("select author_id FROM notebook where notebook.id="+notebookID);
      while (rs.next()){
        idSet.add(rs.getInt(1));
      }
      st.executeUpdate("DELETE FROM notebook where notebook.id=" + notebookID);
      for(Integer in:idSet){
        st.executeUpdate("DELETE FROM author where author.id=" +in);
      }
    } catch (SQLException ex) {
      ex.printStackTrace();
    }
  }

  @Override
  public void deleteNote(int noteID) {
    Statement st;
    try {
      ResultSet rs;
      int authorID;
      st = connection.createStatement();
      rs = st.executeQuery("SELECT author_id From note WHERE note.id=" + noteID);
      if (rs.next()) {
        authorID = rs.getInt(1);
        st.executeUpdate("DELETE FROM note where note.id=" + noteID);
        st.executeUpdate("DELETE FROM author where author.id=" + authorID);
      }
    } catch (SQLException ex) {
      ex.printStackTrace();
    }
  }

  @Override
  public void addNote(int notebookID, String title, String text, String authorName,
      String authorSurname) {
    Statement st;
    try {
      st = connection.createStatement();
      ResultSet rs;
      st.executeUpdate(
          "INSERT INTO `notebook_db`.`author` (`author_name`, `author_surname`) VALUES ('"
              + authorName + "', '" + authorSurname + "');");
      rs = st.executeQuery(
          "select id from author where author.author_name='" + authorName
              + "' and author.author_surname='" + authorSurname + "';");
      if (rs.next()) {
        st.executeUpdate(
            "INSERT INTO `notebook_db`.`note` (`author_id`, `notebook_id`, `title`, `content`) VALUES ("
                + rs.getInt(1) + ", '" + notebookID + "', '" + title + "', '" + text + "');");
      }
    } catch (SQLException ex) {
      ex.printStackTrace();
    }
  } 
}
