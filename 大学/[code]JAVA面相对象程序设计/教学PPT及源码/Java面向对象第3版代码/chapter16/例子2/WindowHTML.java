import java.awt.*;
import java.awt.event.*;
import java.net.*;
import java.io.*;
import javax.swing.*;
public class WindowHTML extends JFrame implements ActionListener,Runnable {
   JButton button;
   URL url;
   JTextField text;
   JEditorPane editPane; 
   byte b[]=new byte[118];
   Thread thread;
   public WindowHTML(){
      text=new JTextField(20);
      editPane=new JEditorPane();
      editPane.setEditable(false);
      button=new JButton("确定");
      button.addActionListener(this);
      thread=new Thread(this);
      JPanel p=new JPanel();
      p.add(new JLabel("输入网址:"));
      p.add(text); 
      p.add(button);
      JScrollPane scroll=new  JScrollPane(editPane);
      add(scroll,BorderLayout.CENTER);
      add(p,BorderLayout.NORTH);
      setBounds(160,60,420,300);
      setVisible(true);
      validate();
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   }
   public void actionPerformed(ActionEvent e) {
      if(!(thread.isAlive())) 
         thread=new Thread(this);
      try{ thread.start();
      }
      catch(Exception ee) {
          text.setText("我正在读取"+url);
      }
   }
   public void run() {
      try { int n=-1;
            editPane.setText(null);
            url=new URL(text.getText().trim());
            editPane.setPage(url);
      }
      catch(Exception e1) {
            text.setText(""+e1);
            return;
      }
   }
}
