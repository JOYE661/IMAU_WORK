package project.data; 
import java.sql.*;
import java.util.*;
public class RandomQueryWord {
   int count =0 ;//随机抽取的数目
   public void setCount(int n){
       count = n;
   }
   public int getCount(){
      return count;
   }
   public Word[] randomQueryWord() { 
      Connection con = ConnectDatabase.connectDatabase();//连接MyEnglishBook数据库
      if(con == null)
         return null;
      Word [] word  = null;
      Statement sql; 
      ResultSet rs;
      try { 
        sql=con.createStatement
        (ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
        rs=sql.executeQuery("select * from word_table");
        rs.last(); 
        int recordAmount =rs.getRow();//结果集中的记录数目
        count = Math.min(count,recordAmount);
        word = new Word[count];
        for(int i=0;i<word.length;i++){
           word[i] = new Word();
        }
        //得到1至recordAmount之间count个互不相同的随机整数（存放在数组index中）：
        int [] index = getRandomNumber(recordAmount,count);
        int m = 0;
        for(int randomNumer:index){ // randomNumer依次取数组index每个单元的值
             rs.absolute(randomNumer);//查询游标移动到第randomNumer行
             word[m].setEnglishWord(rs.getString(1));
             word[m].setMeaning(rs.getString(2));
             m++;
        }
        con.close();
      }
      catch(SQLException e) { 
         System.out.println(e);
      }
      return word;
   } 
   public int [] getRandomNumber(int max,int count) {
     // 得到1至max之间的amount个互不相同的随机整数（包括1和max）：
     int [] randomNumber = new int[count];
     Set<Integer> set=new HashSet<Integer>(); //set不允许有相同的元素
     int size =set.size();
     Random random = new Random();
     while(size<count){
         int number = random.nextInt(max)+1;
         set.add(number); //number放入集合set中
         size =set.size();
     }
     Iterator<Integer> iter=set.iterator();
     int i = 0;
     while(iter.hasNext()) {  //把集合中的随机数放入数组
         Integer te=iter.next();
         randomNumber[i] = te.intValue();
         i++;
     }
     return  randomNumber;
   }  
}
