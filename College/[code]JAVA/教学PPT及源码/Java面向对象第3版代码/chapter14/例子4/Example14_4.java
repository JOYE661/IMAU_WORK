import java.sql.*; 
public class Example14_4 {
   public static void main(String args[]) {
      Connection con;
      Statement sql; 
      ResultSet rs;
      con = GetDBConnection.connectDB("Book","root","");
      if(con == null ) return;
      String updateRecord = 
     "update bookList set chubanDate = '2019-12-26' where name='��ѧӢ��'";
      String record = "('2-306-08465-7','����', 35.8,'2020-3-20'),"+
                      "('5-777-56462-9','����', 29.9,'2019-12-23')";
      String addRecord ="insert into bookList values"+record;
      try { 
          sql=con.createStatement(); 
          int ok = sql.executeUpdate(addRecord);   // ���2����¼
          ok =sql.executeUpdate(updateRecord);     // ����1����¼
          rs = sql.executeQuery("select * from bookList");
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
          System.out.println("��¼��ISBN��ֵ�����ظ�"+e);
      }
  }
}
