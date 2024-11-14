import java.sql.*; 
public class Example14_7{
    public static void main(String args[]){
       Connection con = null;
       Statement sql;
       ResultSet rs; 
       String sqlStr;
       con = GetDBConnection.connectDB("Book","root","");
       if(con == null ) return;
       try{ 
            con.setAutoCommit(false);       //�ȹر��Զ��ύģʽ
            sql = con.createStatement();   //�ٷ���Statement����
            sqlStr = "select name,price from bookList"+
                    " where ISBN='7-302-01465-5'";
            rs = sql.executeQuery(sqlStr);
            rs.next();
            float price1 = rs.getFloat(2);
            System.out.println("����֮ǰ"+rs.getString(1)+"�۸�:"+price1);
            sqlStr = "select name,price from bookList"+
                    " where ISBN='8-302-08465-8'"; 
            rs = sql.executeQuery(sqlStr);
            rs.next();
            float price2 = rs.getFloat(2);
            System.out.println("����֮ǰ"+rs.getString(1)+"�۸�:"+price2);
            float n = 5;  
            price2 = price2-n;
            price1 = price1+n;
            sqlStr = "update bookList set price ="+price2+
                     " where ISBN='8-302-08465-8'";
            sql.executeUpdate(sqlStr);
            sqlStr = "update bookList set price ="+price1+
                     " where ISBN='7-302-01465-5'";
            sql.executeUpdate(sqlStr);
            con.commit(); //��ʼ������,��������쳣ֱ��ִ��catch��
            con.setAutoCommit(true); //�ָ��Զ��ύģʽ
            String s = "select name,price from bookList"+
                      " where ISBN='7-302-01465-5'or ISBN='8-302-08465-8'";
            rs =  sql.executeQuery(s);
            while(rs.next()){
               System.out.println("�����"+rs.getString(1)+"�۸�:"+rs.getFloat(2));  
            }
            con.close();
         }
         catch(SQLException e){
            try{ con.rollback();          //�������������Ĳ���
            }
            catch(SQLException exp){}
         }
    }
}