import java.util.*;
public class GetRandomNumber {
   public static int [] getRandomNumber(int max,int amount) {
       int [] result = new int[amount];  //存放得到的amount随机数
       int [] a = new int[max];          //存放max个整数
       Random random = new Random();
       for(int i = 0;i<a.length;i++){  //将1至max放入数组a
           a[i] = i+1;
       }
       for(int i =0 ;i<amount;i++) {    //得到amount随机数
          int index  = random.nextInt(a.length); //随机得到数组的一个索引值
          result[i] = a[index];
          int [] b = Arrays.copyOfRange(a,0,index);// 数组b存放的是a[0]至a[index-1]
          int [] c = Arrays.copyOfRange(a,index+1,a.length);//数组复制见2.4.8 
          a = new int[b.length+c.length];   //新的数组a中去掉了抽到的数字
          for(int k=0;k<a.length;k++) {
             if(k<b.length)
                a[k] = b[k];
             else
                a[k] = c[k-b.length];
          }
       }
       return result;
   }
}
