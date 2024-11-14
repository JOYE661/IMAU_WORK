package project.data; 
import java.sql.*;
public class QueryOneWord {
   public Word queryOneWord(Word word) { 
      Connection con = ConnectDatabase.connectDatabase();//连接MyEnglishBook数据库
      if(con == null)
         return null;
      Word  foundWord  = null;
      Statement sql; 
      ResultSet rs;
      String str =
      "select * from word_table where word ='"+word.getEnglishWord()+"'";
      try { 
        sql=con.createStatement();
        rs=sql.executeQuery(str);
        if(rs.next()){ 
          foundWord = new Word();
          foundWord.setEnglishWord(rs.getString(1));
          foundWord.setMeaning(rs.getString(2));
        }
        con.close();
      }
      catch(SQLException e) {}
      return foundWord;
   }   
}
