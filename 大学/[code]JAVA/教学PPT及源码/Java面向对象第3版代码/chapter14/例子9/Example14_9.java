import java.sql.*; 
public class Example14_9 {
    public static void main(String args[]) {
       Connection con=null;
       Statement sql; 
       ResultSet rs;
       try{  //加载JDBC-Access连接器:
             Class.forName("com.hxtt.sql.access.AccessDriver"); 
       }
       catch(Exception e){ }
       String databasePath = "./Book.accdb";
       String loginName ="";
       String password ="";
       try{
          con = 
          DriverManager.getConnection("jdbc:Access://"+databasePath, 
                                      loginName, password); //连接
       }
       catch(SQLException e){ 
           System.out.println(e);
       }
       try{
            sql=con.createStatement(); 
            rs=sql.executeQuery("SELECT * FROM bookList");//查表
            while(rs.next()) {
               String number=rs.getString(1);
               String name=rs.getString(2);
               float price=rs.getFloat(3);
               Date date=rs.getDate(4);
               System.out.printf("%s,%s,%.2f,%s\n",number,name,price,date);
            }
            con.close();
      }
      catch(SQLException e) { 
           System.out.println(e);
      }
  }
}
