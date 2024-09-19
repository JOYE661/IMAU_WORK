import java.sql.*; 
public class Example14_1 {
    public static void main(String args[]) {
       Connection con=null;
       Statement sql; 
       ResultSet rs;
       try{  //����JDBC-MySQL8.0������:
            Class.forName("com.mysql.cj.jdbc.Driver"); 
       }
       catch(Exception e){}
       String uri = "jdbc:mysql://localhost:3306/Book?"+
                     "useSSL=false&serverTimezone=CST&characterEncoding=utf-8";
       String user ="root";
       String password ="";
       try{
          con = DriverManager.getConnection(uri,user,password); //����
       }
       catch(SQLException e){
           System.out.println(e);
       }
       try{
            sql=con.createStatement(); 
            rs=sql.executeQuery("SELECT * FROM bookList");//���
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
