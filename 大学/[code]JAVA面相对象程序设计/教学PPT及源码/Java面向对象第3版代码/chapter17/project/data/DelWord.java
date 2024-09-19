package project.data; 
import java.sql.*;
public class DelWord extends ConnectDatabase{
   int isOK ; 
   public int delWord(Word word) {
      Connection con = ConnectDatabase.connectDatabase();//连接MyEnglishBook数据库
      if(con == null)
         return 0;
      try { 
          String SQL ="delete from word_table where word = ? ";
          PreparedStatement sta  = con.prepareStatement(SQL);
          sta.setString(1,word.getEnglishWord());
          isOK = sta.executeUpdate();
          con.close();
      }
      catch(SQLException e) {
          isOK = 0; 
      }
      return isOK;
   }
}
