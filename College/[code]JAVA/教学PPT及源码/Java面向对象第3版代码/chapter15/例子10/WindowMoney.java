import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class WindowMoney extends JFrame implements ActionListener {
   JTextArea text1,text2;
   Bank bank;
   Thread ���,����;
   JButton startShowing=new JButton("��ʼ��ʾ");
   WindowMoney() {
     bank=new Bank();
     ���=new Thread(bank); 
     ����=new Thread(bank);
     ���.setName("���");
     ����.setName("����");
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
      if(!(����.isAlive())&&!(���.isAlive())) {   
          ���=new Thread(bank); 
          ����=new Thread(bank);
          ���.setName("���");
          ����.setName("����");
          bank.setMoney(100);
          text1.setText(null);
          text2.setText(null);
      }
      try{
         ���.start();
         ����.start();
      }
      catch(Exception exp){}
   }
} 
