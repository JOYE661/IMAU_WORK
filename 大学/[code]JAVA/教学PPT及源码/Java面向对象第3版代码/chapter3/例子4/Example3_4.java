enum Season {
   ����,�ļ�,�＾,����   
}
public class Example3_4 {
   public static void main(String args[]) {
       int x=96,y=1;
       Season season=Season.����;
       String str = new String("Java����");
       switch(x+y) {
           case 1 :
             System.out.println(x+y);
             break;    
           case 'a':
             System.out.println(x+y);
           case 10:   
             System.out.println(x+y);
             break;     
           default:  System.out.println("û�а����"+(x+y));
       }
       switch(season) { 
           case ���� :
              System.out.println("¡������");
           case ���� :
              System.out.println("������������");
           case �＾ :   
              System.out.println("�����ջ��ʵ");
              break;  
            case �ļ� :   
              System.out.println("������");   
       }
       switch(str) { 
           case "Java����" :
              System.out.println("ѧϰJava����");
           case "C����" :
              System.out.println("���ѧϰ��C����");
              break;  
      }
  }
}
