import javax.swing.*;
public class Bank implements Runnable {
   int money=100;
   String name; 
   JTextArea text1,text2;
   public void setShowText(JTextArea t1,JTextArea t2) {
      text1=t1;
      text2=t2;
   }
   public void setMoney(int n) {
      money=n;
   }
   public synchronized void ��ȡ(int number) { //��ȡ����
      if(name.equals("���")) {
         for(int i=1;i<=3;i++) { //���ʹ�ô�ȡ��������270������90����Ъһ��
             money=money+number;         
             text1.append("������"+money+"��,��Ϣһ���ٴ�\n");
             try { Thread.sleep(1000);     //��ʱ�����Բ���ʹ�ô�ȡ���� 
             }                             //��Ϊ��ƻ�ûʹ�����ȡ����
             catch(InterruptedException e){}
         }
      }
      else if(name.equals("����")) {
         for(int i=1;i<=2;i++) { //����ʹ�ô�ȡ����ȡ��60��ȡ��30����Ъһ��
             money=money-number;   
             text2.append("������"+money+"��,��Ϣһ����ȡ\n");
             try { Thread.sleep(1000);       //��ʱ����Բ���ʹ�ô�ȡ����
             }                               //��Ϊ���ɻ�ûʹ�����ȡ����
             catch(InterruptedException e){}
         }
      }
   }
   public void run() {
      name=Thread.currentThread().getName();
      if(name.equals("���")) 
         ��ȡ(90);
      else if(name.equals("����"))
         ��ȡ(30);
   }
}