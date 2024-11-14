import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class WindowMoney extends JFrame implements ActionListener {
   JTextArea text1,text2;
   Bank bank;
   Thread 会计,出纳;
   JButton startShowing=new JButton("开始演示");
   WindowMoney() {
     bank=new Bank();
     会计=new Thread(bank); 
     出纳=new Thread(bank);
     会计.setName("会计");
     出纳.setName("出纳");
     text1=new JTextArea(5,16); 
     text2=new JTextArea(5,16);
     bank.setShowText(text1,text2);
     bank.setMoney(100); 
     setLayout(new FlowLayout());
     add(startShowing);
     add(new JScrollPane(text1));
     add(new JScrollPane(text2));
     setVisible(true);
     setSize(570,300);
     startShowing.addActionListener(this);
     setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   }
   public void actionPerformed(ActionEvent e) {
      if(!(出纳.isAlive())&&!(会计.isAlive())) {   
          会计=new Thread(bank); 
          出纳=new Thread(bank);
          会计.setName("会计");
          出纳.setName("出纳");
          bank.setMoney(100);
          text1.setText(null);
          text2.setText(null);
      }
      try{
         会计.start();
         出纳.start();
      }
      catch(Exception exp){}
   }
} 
