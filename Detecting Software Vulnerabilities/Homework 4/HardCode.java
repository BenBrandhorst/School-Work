public class HardCode {
  public static void main(String[] args) throws SQLException {
      String url = "jdbc:sqlserver://localhost/Homework4";
      String user = "hardcodedUsername";
      String pass = "hardedcodedPassword";
      
      getConnect(url, user, pass);
      
  }
  
  public static void getConnect(String database, String account, String password) throws SQLException {
             DriverManager.getConnection(database, account, password);
  }
 
    