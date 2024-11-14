import java.awt.*;
import java.awt.event.*; 
import javax.swing.*;
public class WindowTicket extends JFrame implements Runnable,ActionListener {
   SellTicket ticketAgent;
   Thread 张平,李明;  
   static JTextArea text;
   JButton startBuy=new JButton("开始买票"); 
   WindowTicket() {
      ticketAgent=new SellTicket(); //售票员;
      张平=new Thread(this);
      张平.setName("张平");
      李明=new Thread(this);
      李明.setName("李明"); 
      text=new JTextArea(10,30);
      startBuy.addActionListener(this); 
      add(text,BorderLayout.CENTER);
      add(startBuy,BorderLayout.NORTH);
      setVisible(true);
      setSize(360,300);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   } 
   public void actionPerformed(ActionEvent e) {
      try{  张平.start();
            李明.start();
      }
      catch(Exception exp) {} 
   }
   public void run() {
      if(Thread.currentThread()==张平) {
          ticketAgent.售票规则(20);
      }
      else if(Thread.currentThread()==李明) {
          ticketAgent.售票规则(5);
      }
   }   
}
