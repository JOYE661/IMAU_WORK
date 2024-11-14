import java.sql.*; 
public class GetDBConnection {
    public static Connection connectDB(String DBName,String id,String password) {
        try{  //����JDBC-MySQL8.0������:
            Class.forName("com.mysql.cj.jdbc.Driver"); 
        }
        catch(Exception e){}
        Connection con = null;
        String uri = "jdbc:mysql://localhost:3306/"+DBName+"?"+
                     "useSSL=false&serverTimezone=CST&characterEncoding=utf-8";
        try{
            con = DriverManager.getConnection(uri,id,password); //����
        }
        catch(SQLException e){
            System.out.println(e);
        }
        return con;
   }
}
