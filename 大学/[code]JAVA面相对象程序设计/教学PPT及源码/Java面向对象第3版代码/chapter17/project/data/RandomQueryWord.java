package project.data; 
import java.sql.*;
import java.util.*;
public class RandomQueryWord {
   int count =0 ;//�����ȡ����Ŀ
   public void setCount(int n){
       count = n;
   }
   public int getCount(){
      return count;
   }
   public Word[] randomQueryWord() { 
      Connection con = ConnectDatabase.connectDatabase();//����MyEnglishBook���ݿ�
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
        int recordAmount =rs.getRow();//������еļ�¼��Ŀ
        count = Math.min(count,recordAmount);
        word = new Word[count];
        for(int i=0;i<word.length;i++){
           word[i] = new Word();
        }
        //�õ�1��recordAmount֮��count��������ͬ��������������������index�У���
        int [] index = getRandomNumber(recordAmount,count);
        int m = 0;
        for(int randomNumer:index){ // randomNumer����ȡ����indexÿ����Ԫ��ֵ
             rs.absolute(randomNumer);//��ѯ�α��ƶ�����randomNumer��
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
     // �õ�1��max֮���amount��������ͬ���������������1��max����
     int [] randomNumber = new int[count];
     Set<Integer> set=new HashSet<Integer>(); //set����������ͬ��Ԫ��
     int size =set.size();
     Random random = new Random();
     while(size<count){
         int number = random.nextInt(max)+1;
         set.add(number); //number���뼯��set��
         size =set.size();
     }
     Iterator<Integer> iter=set.iterator();
     int i = 0;
     while(iter.hasNext()) {  //�Ѽ����е��������������
         Integer te=iter.next();
         randomNumber[i] = te.intValue();
         i++;
     }
     return  randomNumber;
   }  
}
