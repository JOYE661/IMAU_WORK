import java.sql.*; 
public class Example14_5 {
   public static void main(String args[]) {
      Connection con;
      PreparedStatement preSql;  //预处理语句对象preSql
      ResultSet rs;
      con = GetDBConnection.connectDB("Book","root","");
      if(con == null ) return;
      String sqlStr ="insert into bookList values(?,?,?,?)";
      try { 
          preSql = con.prepareStatement(sqlStr);//得到预处理语句对象preSql
          preSql.setString(1,"1-602-98465-0"); //设置第1个?代表的值
          preSql.setString(2,"红楼梦");         //设置第2个?代表的值
          preSql.setFloat(3,256.9F);            //设置第3个?代表的值
          preSql.setString(4,"1990-1-31");         //设置第4个?代表的值   
          int ok = preSql.executeUpdate();       //预处理语句调用方法
          sqlStr="select * from bookList where name like ? ";
          preSql = con.prepareStatement(sqlStr);//得到预处理语句对象preSql
          preSql.setString(1,"%数%");             //设置第1个?代表的值
          rs = preSql.executeQuery();
          while(rs.next()) { 
               String ISBN =  rs.getString(1);
               String name =  rs.getString(2);
               String price = rs.getString(3);
               String date =  rs.getString(4);
               System.out.printf("%s,%s,%s,%s.\n",ISBN,name,price,date);
          }
          con.close();
      }
      catch(SQLException e) { 
          System.out.println("记录中ISBN值不能重复"+e);
      }
  }
}   
