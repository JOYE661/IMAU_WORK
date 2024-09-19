import java.sql.*; 
public class Example14_5 {
   public static void main(String args[]) {
      Connection con;
      PreparedStatement preSql;  //Ԥ����������preSql
      ResultSet rs;
      con = GetDBConnection.connectDB("Book","root","");
      if(con == null ) return;
      String sqlStr ="insert into bookList values(?,?,?,?)";
      try { 
          preSql = con.prepareStatement(sqlStr);//�õ�Ԥ����������preSql
          preSql.setString(1,"1-602-98465-0"); //���õ�1��?�����ֵ
          preSql.setString(2,"��¥��");         //���õ�2��?�����ֵ
          preSql.setFloat(3,256.9F);            //���õ�3��?�����ֵ
          preSql.setString(4,"1990-1-31");         //���õ�4��?�����ֵ   
          int ok = preSql.executeUpdate();       //Ԥ���������÷���
          sqlStr="select * from bookList where name like ? ";
          preSql = con.prepareStatement(sqlStr);//�õ�Ԥ����������preSql
          preSql.setString(1,"%��%");             //���õ�1��?�����ֵ
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
          System.out.println("��¼��ISBNֵ�����ظ�"+e);
      }
  }
}   
