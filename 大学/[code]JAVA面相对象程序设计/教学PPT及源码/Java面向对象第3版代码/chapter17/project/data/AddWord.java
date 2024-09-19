package project.data; 
import java.sql.*;
public class AddWord {
   int isOK ; 
   public int insertWord(Word word) {
      Connection con = ConnectDatabase.connectDatabase();//连接MyEnglishBook数据库
      if(con == null)
         return 0;
      try { 
          String SQL ="insert into word_table values(?,?)";
          PreparedStatement sta  = con.prepareStatement(SQL);
          sta.setString(1,word.getEnglishWord());
          sta.setString(2,word.getMeaning());
          isOK = sta.executeUpdate();  
          con.close();
      }
      catch(SQLException e) {
          isOK = 0; //word_table表中word字段是主键，即不允许单词重复
      }
      return isOK;
   }
}
