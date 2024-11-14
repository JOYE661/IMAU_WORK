package geng.handle; 
import geng.model.Login;
import java.sql.*;
import javax.swing.JOptionPane;
public class HandleLogin {
   Connection con;
   PreparedStatement preSql;
   ResultSet rs;  
   public HandleLogin(){
      try{  //¼ÓÔØJDBC-MySQL8.0.15Á¬½ÓÆ÷:
            Class.forName("com.mysql.cj.jdbc.Driver"); 
       }
       catch(Exception e){}
       String uri = "jdbc:mysql://localhost:3306/user?"+
                     "useSSL=false&serverTimezone=CST&characterEncoding=utf-8";
       String user ="root";
       String password ="";
       try{  
         con = DriverManager.getConnection(uri,"root",""); //Á¬½Ó´úÂë
      }
      catch(SQLException e){}
   }
   public Login queryVerify(Login loginModel) {
      String id = loginModel.getID();
      String pw = loginModel.getPassword();
      String sqlStr ="select id,password from register where "+
                      "id = ? and password = ?";
      try { 
          preSql = con.prepareStatement(sqlStr);
          preSql.setString(1,id);       
          preSql.setString(2,pw);  
          rs = preSql.executeQuery(); 
          if(rs.next()==true) {
             loginModel.setLoginSuccess(true);
             JOptionPane.showMessageDialog(null,"µÇÂ¼³É¹¦",
                             "¹§Ï²",JOptionPane.WARNING_MESSAGE);
          }
          else {
             loginModel.setLoginSuccess(false);
             JOptionPane.showMessageDialog(null,"µÇÂ¼Ê§°Ü",
                "µÇÂ¼Ê§°Ü£¬ÖØÐÂµÇÂ¼",JOptionPane.WARNING_MESSAGE);
          }
          con.close();
      }
      catch(SQLException e) {}
      return loginModel;
   }
}
