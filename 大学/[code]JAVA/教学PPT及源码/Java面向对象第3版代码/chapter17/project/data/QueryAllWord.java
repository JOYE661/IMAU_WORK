package project.data; 
import java.sql.*;
public class QueryAllWord {
   public Word[] queryAllWord() { 
      Connection con = ConnectDatabase.connectDatabase();//连接MyEnglishBook数据库
      if(con == null)
         return null;
      Word [] word  = null;
      Statement sql; 
      ResultSet rs;
      try { 
        sql=con.createStatement
         (ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
        rs=sql.executeQuery("select * from word_table");
        rs.last(); 
        int recordAmount =rs.getRow();//结果集中的全部记录
        word = new Word[recordAmount];
        for(int i=0;i<word.length;i++){
          word[i] = new Word();
        }
        rs.beforeFirst();
        int i=0;
        while(rs.next()) { 
          word[i].setEnglishWord(rs.getString(1));
          word[i].setMeaning(rs.getString(2));
          i++;
        }
        con.close();
      }
      catch(SQLException e) {}
      return word;
   }   
}
