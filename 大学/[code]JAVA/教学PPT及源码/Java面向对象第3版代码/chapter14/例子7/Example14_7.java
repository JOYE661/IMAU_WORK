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
            con.setAutoCommit(false);       //先关闭自动提交模式
            sql = con.createStatement();   //再返回Statement对象
            sqlStr = "select name,price from bookList"+
                    " where ISBN='7-302-01465-5'";
            rs = sql.executeQuery(sqlStr);
            rs.next();
            float price1 = rs.getFloat(2);
            System.out.println("事务之前"+rs.getString(1)+"价格:"+price1);
            sqlStr = "select name,price from bookList"+
                    " where ISBN='8-302-08465-8'"; 
            rs = sql.executeQuery(sqlStr);
            rs.next();
            float price2 = rs.getFloat(2);
            System.out.println("事务之前"+rs.getString(1)+"价格:"+price2);
            float n = 5;  
            price2 = price2-n;
            price1 = price1+n;
            sqlStr = "update bookList set price ="+price2+
                     " where ISBN='8-302-08465-8'";
            sql.executeUpdate(sqlStr);
            sqlStr = "update bookList set price ="+price1+
                     " where ISBN='7-302-01465-5'";
            sql.executeUpdate(sqlStr);
            con.commit(); //开始事务处理,如果发生异常直接执行catch块
            con.setAutoCommit(true); //恢复自动提交模式
            String s = "select name,price from bookList"+
                      " where ISBN='7-302-01465-5'or ISBN='8-302-08465-8'";
            rs =  sql.executeQuery(s);
            while(rs.next()){
               System.out.println("事务后"+rs.getString(1)+"价格:"+rs.getFloat(2));  
            }
            con.close();
         }
         catch(SQLException e){
            try{ con.rollback();          //撤销事务所做的操作
            }
            catch(SQLException exp){}
         }
    }
}