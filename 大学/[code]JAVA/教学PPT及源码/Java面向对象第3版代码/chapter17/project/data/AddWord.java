package project.data; 
import java.sql.*;
public class AddWord {
   int isOK ; 
   public int insertWord(Word word) {
      Connection con = ConnectDatabase.connectDatabase();//����MyEnglishBook���ݿ�
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
          isOK = 0; //word_table����word�ֶ��������������������ظ�
      }
      return isOK;
   }
}
