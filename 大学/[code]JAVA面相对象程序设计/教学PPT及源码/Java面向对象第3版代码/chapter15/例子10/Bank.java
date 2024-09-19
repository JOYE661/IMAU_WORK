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
   public synchronized void 存取(int number) { //存取方法
      if(name.equals("会计")) {
         for(int i=1;i<=3;i++) { //会计使用存取方法存入270，存入90，稍歇一下
             money=money+number;         
             text1.append("帐上有"+money+"万,休息一会再存\n");
             try { Thread.sleep(1000);     //这时出纳仍不能使用存取方法 
             }                             //因为会计还没使用完存取方法
             catch(InterruptedException e){}
         }
      }
      else if(name.equals("出纳")) {
         for(int i=1;i<=2;i++) { //出纳使用存取方法取出60，取出30，稍歇一下
             money=money-number;   
             text2.append("帐上有"+money+"万,休息一会再取\n");
             try { Thread.sleep(1000);       //这时会计仍不能使用存取方法
             }                               //因为出纳还没使用完存取方法
             catch(InterruptedException e){}
         }
      }
   }
   public void run() {
      name=Thread.currentThread().getName();
      if(name.equals("会计")) 
         存取(90);
      else if(name.equals("出纳"))
         存取(30);
   }
}