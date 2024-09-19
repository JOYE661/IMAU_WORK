package geng.handle; 
import geng.model.Register;
import java.sql.*;
import javax.swing.JOptionPane;
public class HandleRegister {
   Connection con;
   PreparedStatement preSql;  
   public HandleRegister(){
      try{  //加载JDBC-MySQL8.0.15连接器:
            Class.forName("com.mysql.cj.jdbc.Driver"); 
       }
       catch(Exception e){}
       String uri = "jdbc:mysql://localhost:3306/user?"+
                     "useSSL=false&serverTimezone=CST&characterEncoding=utf-8";
       String user ="root";
       String password ="";
      try{  
         con = DriverManager.getConnection(uri,"root",""); //连接代码
      }
      catch(SQLException e){}
   }
   public void writeRegisterModel(Register person) {
      String sqlStr ="insert into register values(?,?,?)";
      int ok = 0;
      try { 
          preSql = con.prepareStatement(sqlStr);
          preSql.setString(1,person.getID());       
          preSql.setString(2,person.getPassword());  
          preSql.setString(3,person.getBirth());
          ok = preSql.executeUpdate();
          con.close();
      }
      catch(SQLException e) {
         JOptionPane.showMessageDialog(null,"id不能重复","警告",
                                   JOptionPane.WARNING_MESSAGE);
      }
      if(ok!=0) {
         JOptionPane.showMessageDialog(null,"注册成功",
                             "恭喜",JOptionPane.WARNING_MESSAGE);
      }
   }
}
