import java.util.*;
public class GetRandomNumber {
   public static int [] getRandomNumber(int max,int amount) {
       int [] result = new int[amount];  //��ŵõ���amount�����
       int [] a = new int[max];          //���max������
       Random random = new Random();
       for(int i = 0;i<a.length;i++){  //��1��max��������a
           a[i] = i+1;
       }
       for(int i =0 ;i<amount;i++) {    //�õ�amount�����
          int index  = random.nextInt(a.length); //����õ������һ������ֵ
          result[i] = a[index];
          int [] b = Arrays.copyOfRange(a,0,index);// ����b��ŵ���a[0]��a[index-1]
          int [] c = Arrays.copyOfRange(a,index+1,a.length);//���鸴�Ƽ�2.4.8 
          a = new int[b.length+c.length];   //�µ�����a��ȥ���˳鵽������
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
