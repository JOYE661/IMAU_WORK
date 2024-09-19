import java.awt.*;
import java.awt.event.*;   
import javax.swing.*;
public class WindowWord extends JFrame implements ActionListener,Runnable {
   JTextField inputText,showText;
   JLabel label=new JLabel("��ӭʹ�ñ��ֵ�");
   JButton fast=new JButton("���ٹ���");
   Thread scrollWord=null;  //���������Ļ
   Police police;           //������
   WindowWord() {
      setLayout(new FlowLayout());
      scrollWord=new Thread(this);
      inputText=new JTextField(6);
      showText=new JTextField(6);
      label.setFont(new Font("����_GB2312",Font.BOLD,24));
      add(inputText); 
      add(showText);
      add(fast);
      add(label);
      police=new Police();
      police.setJTextField(showText);
      inputText.addActionListener(police);
      fast.addActionListener(this);  
      setBounds(100,100,400,280);
      setVisible(true);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      scrollWord.start();    //��AWT-Windows�߳�������scrollWord�߳�
   }
   public void run() {
      while(true) {
         int x=label.getBounds().x;
         int y=50;
         x=x+5; 
         label.setLocation(x,y);
         if(x>380) {
             x=10;
             label.setLocation(x,y);
         } 
         try{ Thread.sleep(200);
         } 
         catch(InterruptedException e){}
         String str=inputText.getText();
         if(str.equals("end")) {
             return;          //����run����������scrollWord�߳�����
         }
      }
   }
   public void actionPerformed(ActionEvent e) {
      scrollWord.interrupt();  //�������ߵ��̣߳��Ա�ӿ���ģ�Ĺ���
   }
}
