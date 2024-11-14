import java.sql.*; 
public class Example14_2 {
    public static void main(String args[]) {
        Connection con;
        Statement sql; 
        ResultSet rs;
        con = GetDBConnection.connectDB("Book","root","");
        if(con == null ) return;
        try { 
            sql=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                                    ResultSet.CONCUR_READ_ONLY);
            rs = sql.executeQuery("SELECT * FROM bookList ");
            rs.last();
            int max = rs.getRow();
            System.out.println("表共有"+max+"条记录,随机抽取2条记录：");
            int [] a =GetRandomNumber.getRandomNumber(max,2);
            for(int i:a){ // i依次取数组每个单元的值（见3.7）
                rs.absolute(i);                 //游标移动到第i行
                String ISBN =  rs.getString(1);
                String name =  rs.getString(2);
                String price = rs.getString(3);
                String date =  rs.getString(4);
                System.out.printf("%s,%s,%s,%s.\n",ISBN,name,price,date);
            }
            con.close();
        }
        catch(SQLException e) {}
    }
}
