import java.awt.*;
import java.awt.event.*;
import java.net.*;
import java.io.*;
import javax.swing.event.*;
import javax.swing.*;
public class WindowLink extends JFrame implements ActionListener,Runnable {
   JButton button;
   URL url;
   JTextField text;
   JEditorPane editPane; 
   byte b[]=new byte[118];
   Thread thread;
   public WindowLink(){
      text=new JTextField(20);
      editPane=new JEditorPane();
      editPane.setEditable(false);
      button=new JButton("»∑∂®");
      button.addActionListener(this);
      thread=new Thread(this);
      JPanel p=new JPanel();
      p.add(new JLabel(" ‰»ÎÕ¯÷∑:"));
      p.add(text); 
      p.add(button);
      JScrollPane scroll=new JScrollPane(editPane);
      add(scroll,BorderLayout.CENTER);
      add(p,BorderLayout.NORTH);
      setBounds(60,60,460,300);
      setVisible(true);
      validate();
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      editPane.addHyperlinkListener(new HyperlinkListener() {
                         public void hyperlinkUpdate(HyperlinkEvent e){ 
                           if(e.getEventType()==HyperlinkEvent.EventType.ACTIVATED){
                                try{ editPane.setPage(e.getURL());
                                }     
                                catch(IOException e1){}
                            }
                         }});
   }
   public void actionPerformed(ActionEvent e) {
      if(!(thread.isAlive())) 
         thread=new Thread(this);
      try{ thread.start();
      }
      catch(Exception ee){}
   }
   public void run() {
      try { int n=-1;
            editPane.setText(null);
            url=new URL(text.getText().trim());
            editPane.setPage(url);
      }
      catch(Exception e1) {
            return;
      }
   }
}
