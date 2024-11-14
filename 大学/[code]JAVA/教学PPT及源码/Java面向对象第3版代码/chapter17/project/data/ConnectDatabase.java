package project.data; 
import java.sql.*;
public class ConnectDatabase{
   public static Connection connectDatabase() {
      Connection con = null;
      try{Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
      }
      catch(Exception e){}
      try{  
        String uri ="jdbc:derby:MyEnglishBook;create=false";
        con=DriverManager.getConnection(uri);//连接数据库代码
      }
      catch(Exception e){}
      return con;
   }
}
