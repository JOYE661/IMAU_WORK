import java.awt.*;
import java.awt.event.*;   
import javax.swing.*;
public class WindowWord extends JFrame implements ActionListener,Runnable {
   JTextField inputText,showText;
   JLabel label=new JLabel("欢迎使用本字典");
   JButton fast=new JButton("加速滚动");
   Thread scrollWord=null;  //负责滚动字幕
   Police police;           //监视器
   WindowWord() {
      setLayout(new FlowLayout());
      scrollWord=new Thread(this);
      inputText=new JTextField(6);
      showText=new JTextField(6);
      label.setFont(new Font("楷体_GB2312",Font.BOLD,24));
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
      scrollWord.start();    //在AWT-Windows线程中启动scrollWord线程
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
             return;          //结束run方法，导致scrollWord线程死亡
         }
      }
   }
   public void actionPerformed(ActionEvent e) {
      scrollWord.interrupt();  //吵醒休眠的线程，以便加快字模的滚动
   }
}
