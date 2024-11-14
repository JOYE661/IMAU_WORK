package project.data; 
import java.sql.*;
public class UpdateWord {
   int isOK  ; 
   public int updateWord(Word word) {
      Connection con = ConnectDatabase.connectDatabase();//����MyEnglishBook���ݿ�
      if(con == null)
         return 0;
      try { 
          String SQL ="update word_table set meaning = ? where word = ? ";
          PreparedStatement sta  = con.prepareStatement(SQL);
          sta.setString(1,word.getMeaning());
          sta.setString(2,word.getEnglishWord());
          isOK = sta.executeUpdate();
          con.close();
      }
      catch(SQLException e) {
          isOK = 0; 
      }
       return isOK;
   }
}
