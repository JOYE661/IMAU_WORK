import java.util.Scanner;
public class Example2_3 {
    public static void main (String args[ ]){
        System.out.println("�ÿո�(��س�)���ָ����������ɸ���,�������#������\nȻ��س�ȷ��");
        Scanner reader=new Scanner(System.in);
        double sum=0;
        int m=0;
        while(reader.hasNextDouble()){
           double x = reader.nextDouble(); 
           m=m+1;
           sum=sum+x;
        }
        System.out.println(m+"�����ĺ�Ϊ"+sum);
        System.out.println(m+"������ƽ��ֵ"+sum/m); 
    }
}
