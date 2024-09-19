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
            System.out.println("����"+max+"����¼,�����ȡ2����¼��");
            int [] a =GetRandomNumber.getRandomNumber(max,2);
            for(int i:a){ // i����ȡ����ÿ����Ԫ��ֵ����3.7��
                rs.absolute(i);                 //�α��ƶ�����i��
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
