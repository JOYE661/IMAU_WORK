package project.data;
import java.sql.*;
public class CreateDatabaseAndTable{
   Connection con;
   public  CreateDatabaseAndTable(){
      try{Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
      }
      catch(Exception e){}
      try{ //创建名字是MyEnglishBook的数据库： 
         String uri ="jdbc:derby:MyEnglishBook;create=true";
         con=DriverManager.getConnection(uri); //连接数据库代码
      }
      catch(Exception e){}
      try {
          Statement sta = con.createStatement();
          String SQL="create table word_table"+
          "(word varchar(50) primary key,meaning varchar(200))";
          sta.executeUpdate(SQL);   //创建表
          con.close();
      }
      catch(SQLException e) { //如果表已经存在，将触发SQL异常，不再创建该表
      }
   }
}
