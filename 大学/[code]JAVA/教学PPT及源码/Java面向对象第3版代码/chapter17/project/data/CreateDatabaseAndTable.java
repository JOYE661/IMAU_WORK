package project.data;
import java.sql.*;
public class CreateDatabaseAndTable{
   Connection con;
   public  CreateDatabaseAndTable(){
      try{Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
      }
      catch(Exception e){}
      try{ //����������MyEnglishBook�����ݿ⣺ 
         String uri ="jdbc:derby:MyEnglishBook;create=true";
         con=DriverManager.getConnection(uri); //�������ݿ����
      }
      catch(Exception e){}
      try {
          Statement sta = con.createStatement();
          String SQL="create table word_table"+
          "(word varchar(50) primary key,meaning varchar(200))";
          sta.executeUpdate(SQL);   //������
          con.close();
      }
      catch(SQLException e) { //������Ѿ����ڣ�������SQL�쳣�����ٴ����ñ�
      }
   }
}
