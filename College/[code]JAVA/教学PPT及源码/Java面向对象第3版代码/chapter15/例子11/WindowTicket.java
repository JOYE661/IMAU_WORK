import java.awt.*;
import java.awt.event.*; 
import javax.swing.*;
public class WindowTicket extends JFrame implements Runnable,ActionListener {
   SellTicket ticketAgent;
   Thread ��ƽ,����;  
   static JTextArea text;
   JButton startBuy=new JButton("��ʼ��Ʊ"); 
   WindowTicket() {
      ticketAgent=new SellTicket(); //��ƱԱ;
      ��ƽ=new Thread(this);
      ��ƽ.setName("��ƽ");
      ����=new Thread(this);
      ����.setName("����"); 
      text=new JTextArea(10,30);
      startBuy.addActionListener(this); 
      add(text,BorderLayout.CENTER);
      add(startBuy,BorderLayout.NORTH);
      setVisible(true);
      setSize(360,300);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   } 
   public void actionPerformed(ActionEvent e) {
      try{  ��ƽ.start();
            ����.start();
      }
      catch(Exception exp) {} 
   }
   public void run() {
      if(Thread.currentThread()==��ƽ) {
          ticketAgent.��Ʊ����(20);
      }
      else if(Thread.currentThread()==����) {
          ticketAgent.��Ʊ����(5);
      }
   }   
}
